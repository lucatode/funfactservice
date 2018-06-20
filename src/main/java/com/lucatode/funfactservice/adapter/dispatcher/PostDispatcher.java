package com.lucatode.funfactservice.adapter.dispatcher;

import com.lucatode.funfactservice.adapter.http.HttpPostClient;
import com.lucatode.funfactservice.domain.PostErogator;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostDispatcher implements PostErogator {

  private HttpPostClient defaultHttpPostClient;
  private Logger logger;
  private String channel;

  @Autowired
  public PostDispatcher(HttpPostClient defaultHttpPostClient, Logger logger, String channel){
    this.defaultHttpPostClient = defaultHttpPostClient;
    this.logger = logger;
    this.channel = channel;
  }

  @Override
  public void erogate(Post toErogate) {
    try{

      final NotificationMessage notificationMessage =
              new NotificationMessage("17DF3DF522AA1E991587D2E747404B958224F8A1CC53A1A2154060F5D75BEEEC", "funfactservice", toErogate.getLink());
      defaultHttpPostClient.postJson(notificationMessage.toJson());
    }catch(Exception e){
      logger.err("POST_DISPATCHER", e.getMessage());
    }

  }

  private class NotificationMessage{
    String Key;
    String Source;
    String Message;

    public NotificationMessage(String key, String source, String message) {
      Key = key;
      Source = source;
      Message = message;
    }


    public String toJson() {
      return "{\"Key\":\""+this.Key+"\",\"Source\":\""+this.Source+"\",\"Message\":\""+this.Message+"\"}";
    }
  }

}
