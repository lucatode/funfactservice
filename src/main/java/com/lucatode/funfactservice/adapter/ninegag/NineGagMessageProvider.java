package com.lucatode.funfactservice.adapter.ninegag;

import com.lucatode.funfactservice.adapter.http.HttpGetClient;
import com.lucatode.funfactservice.domain.MessageProvider;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NineGagMessageProvider implements MessageProvider {

  private final HttpGetClient client;
  private final Logger logger;

  @Autowired
  public NineGagMessageProvider(HttpGetClient client, Logger logger) {
    this.client = client;
    this.logger = logger;
  }

  @Override
  public List<Post> GetPosts(String url) {
    return null;
  }
}
