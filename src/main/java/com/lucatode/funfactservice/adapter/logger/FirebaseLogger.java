package com.lucatode.funfactservice.adapter.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucatode.funfactservice.adapter.http.HttpPostClient;
import com.lucatode.funfactservice.domain.entity.LogMessage;
import com.lucatode.funfactservice.domain.repository.Logger;

import java.util.Date;

public class FirebaseLogger implements Logger {

    private final HttpPostClient client;
    private final String url;

    public FirebaseLogger(HttpPostClient client, String url) {
        this.client = client;
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
            client.postJson(url, json);
        }catch (Exception e){ }
    }





}
