package com.lucatode.funfactservice.adapter.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.apache.http.protocol.HTTP.USER_AGENT;

@Component
public class DefaultHttpGetClient implements HttpGetClient {

  private final String url;

  public DefaultHttpGetClient(String url) {
    this.url = url;
  }

  @Override
  public String getGetCallResult() {
    HttpClient client = HttpClientBuilder.create().build();
    HttpGet request = new HttpGet(url);
    request.addHeader("User-Agent", USER_AGENT);
    StringBuffer result = new StringBuffer();

    try {
      HttpResponse response = client.execute(request);
      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

      String line = "";
      while ((line = rd.readLine()) != null) {
        result.append(line);
      }
    } catch (Exception e) {

    }

    return result.toString();
  }
}
