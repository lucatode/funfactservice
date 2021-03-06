package com.lucatode.funfactservice.adapter.http;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DefaultHttpPostClient implements HttpPostClient {

  private final String url;

  public DefaultHttpPostClient(String url) {
    this.url = url;
  }

  @Override
  public int postJson(String json) throws IOException {
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
