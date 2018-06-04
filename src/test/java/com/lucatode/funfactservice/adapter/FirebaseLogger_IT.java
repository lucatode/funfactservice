package com.lucatode.funfactservice.adapter;

import com.lucatode.funfactservice.adapter.http.HttpPostClient;
import com.lucatode.funfactservice.adapter.logger.FirebaseLogger;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FirebaseLogger_IT {

    @Mock
    private HttpPostClient poster;

    @Test
    public void postAnInfoMessage() throws IOException {
        new FirebaseLogger(poster,"https://xxxxxx.firebaseio.com/redditLogs.json").info("Test", "{\"id\":3,\"name\":\"John\"}" );
    }

    @Test
    public void postAWarnMessage() throws IOException {
        new FirebaseLogger(poster,"https://xxxxxx.firebaseio.com/redditLogs.json").warn("Test", "{\"id\":3,\"name\":\"John\"}" );
    }

    @Test
    public void postAnErrorMessage() throws IOException {
        new FirebaseLogger(poster,"https://xxxxxx.firebaseio.com/redditLogs.json").err("Test", "{\"id\":3,\"name\":\"John\"}" );
    }




}
