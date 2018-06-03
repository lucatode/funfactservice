package com.lucatode.funfactservice.adapter.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucatode.funfactservice.domain.entity.LogMessage;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.Date;

public class FirebaseLogger implements Logger {

    private final String url;

    public FirebaseLogger(String url) {
        this.url = url;
    }

    @Override
    public void info(String source, String text) {
        WriteMessage(source,text, "INFO");
    }

    @Override
    public void warn(String source, String text) {
        WriteMessage(source,text, "WARNING");
    }

    @Override
    public void err(String source, String text) {
        WriteMessage(source,text, "ERROR");
    }

    private void WriteMessage(String source, String text, String level) {
        LogMessage message = new LogMessage.LogMessageBuilder()
                .withSource(source)
                .withText(text)
                .withLevel(level)
                .withDate(new Date().toString())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        try{
            String json =  mapper.writeValueAsString(message);
            DoPostCall(url, json);
        }catch (Exception e){ }
    }


    public int DoPostCall(String url, String json) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        client.close();
        return statusCode;
    }


}
