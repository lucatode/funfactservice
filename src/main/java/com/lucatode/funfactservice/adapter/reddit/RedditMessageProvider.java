package com.lucatode.funfactservice.adapter.reddit;

import com.lucatode.funfactservice.Entity.Child;
import com.lucatode.funfactservice.Entity.Example;
import com.lucatode.funfactservice.domain.MessageProvider;
import com.lucatode.funfactservice.domain.entity.Post;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.protocol.HTTP.USER_AGENT;

public class RedditMessageProvider implements MessageProvider {

    public List<Post> GetPosts(String url) {
        String result = getGetCallResult(url);
        List<Post> posts = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        try{
            Example s = mapper.readValue(result, Example.class);
            List<Child> children = s.getData().getChildren();
            children.sort( (c1,c2) -> c2.getData().getUps() - c1.getData().getUps());
            children.forEach( c -> {

                posts.add(
                        new Post.PostBuilder()
                                .withId(c.getData().getId())
                                .withTitle(c.getData().getTitle())
                                .withBody(c.getData().getSelftext())
                                .withImg("")
                                .withLink(c.getData().getUrl())
                                .build()
                );
            });
        }catch (Exception e){

        }

        return posts;
    }

    private String getGetCallResult(String url){
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
