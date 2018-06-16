package com.lucatode.funfactservice.adapter;

import com.lucatode.funfactservice.adapter.http.DefaultHttpPostClient;
import com.lucatode.funfactservice.adapter.http.HttpPostClient;
import com.lucatode.funfactservice.adapter.logger.FirebaseLogger;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;

public class FirebaseLogger_IT {

  @Mock
  private HttpPostClient poster;

  @Test
  public void postAnInfoMessage() throws IOException {
    new FirebaseLogger(poster).info("Test", "{\"id\":3,\"name\":\"John\"}");
  }

  @Test
  public void postAWarnMessage() throws IOException {
    new FirebaseLogger(poster).warn("Test", "{\"id\":3,\"name\":\"John\"}");
  }

  @Test
  public void postAnErrorMessage() throws IOException {
    new FirebaseLogger(poster).err("Test", "{\"id\":3,\"name\":\"John\"}");
  }


  @Test
  public void IT() {
    String LOGGER_URL = "https://xxxxxxxxxxxx.firebaseio.com/reddit_logger.json";
    HttpPostClient client = new DefaultHttpPostClient(LOGGER_URL);
    new FirebaseLogger(client).info("Test", "{\"id\":3,\"name\":\"John\"}");
    new FirebaseLogger(client).warn("Test", "{\"id\":3,\"name\":\"John\"}");
    new FirebaseLogger(client).err("Test", "{\"id\":3,\"name\":\"John\"}");
  }


}
