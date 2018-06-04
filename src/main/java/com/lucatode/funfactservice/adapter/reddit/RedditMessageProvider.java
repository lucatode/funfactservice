package com.lucatode.funfactservice.adapter.reddit;

import com.lucatode.funfactservice.adapter.reddit.Entity.Child;
import com.lucatode.funfactservice.adapter.reddit.Entity.Example;
import com.lucatode.funfactservice.adapter.http.HttpGetClient;
import com.lucatode.funfactservice.domain.MessageProvider;
import com.lucatode.funfactservice.domain.entity.Post;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class RedditMessageProvider implements MessageProvider {

    private final HttpGetClient client;

    public RedditMessageProvider(HttpGetClient client) {
        this.client = client;
    }

    public List<Post> GetPosts(String url) {
        String result = client.getGetCallResult(url);
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



}
