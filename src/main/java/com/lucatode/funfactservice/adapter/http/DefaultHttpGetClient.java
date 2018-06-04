package com.lucatode.funfactservice.adapter.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.apache.http.protocol.HTTP.USER_AGENT;

public class DefaultHttpGetClient implements HttpGetClient {
    @Override
    public String getGetCallResult(String url){
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent", USER_AGENT);
        StringBuffer result = new StringBuffer();

        try{

            HttpResponse response = client.execute(request);

            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));


            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        }catch (Exception e){

        }

        return result.toString();
    }
}
