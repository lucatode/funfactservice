package com.lucatode.funfactservice.adapter;

import com.lucatode.funfactservice.adapter.logger.FirebaseLogger;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FirebaseLogger_IT {

    @Test
    public void whenPostJsonUsingHttpClient_thenCorrect() throws IOException {
        int status = DoPostCall("https://condorbot-c36af.firebaseio.com/redditLogs.json", "{\"id\":2,\"name\":\"John\"}" );
        new FirebaseLogger("").DoPostCall("https://condorbot-c36af.firebaseio.com/redditLogs.json", "{\"id\":3,\"name\":\"John\"}" );

        assertThat(status, is(200));
    }

    private int DoPostCall(String url, String json) throws IOException {
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
