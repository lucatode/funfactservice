package com.lucatode.funfactservice.adapter.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucatode.funfactservice.adapter.http.HttpPostClient;
import com.lucatode.funfactservice.domain.entity.LogMessage;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FirebaseLogger implements Logger {

    private final HttpPostClient client;

    @Autowired
    public FirebaseLogger(HttpPostClient client) {
        this.client = client;
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
            client.postJson(json);
        }catch (Exception e){
          System.out.println(e.getMessage());
        }
    }





}
