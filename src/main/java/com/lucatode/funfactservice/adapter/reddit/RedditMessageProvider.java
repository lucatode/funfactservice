package com.lucatode.funfactservice.adapter.reddit;

import com.lucatode.funfactservice.adapter.reddit.Entity.Child;
import com.lucatode.funfactservice.adapter.reddit.Entity.Example;
import com.lucatode.funfactservice.adapter.http.HttpGetClient;
import com.lucatode.funfactservice.domain.MessageProvider;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RedditMessageProvider implements MessageProvider {

    private final HttpGetClient client;
    private final Logger logger;

    @Autowired
    public RedditMessageProvider(HttpGetClient client, Logger logger) {
      this.client = client;
      this.logger = logger;
    }

    public List<Post> GetPostsByUps(String url) {
        String result = client.getGetCallResult();
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
                                .withImg(c.getData().getThumbnail())
                                .withLink(c.getData().getUrl())
                                .withTimeStamp(new Date())
                                .withSubreddit(c.getData().getSubreddit())
                                .withType(url)
                                .withScore(c.getData().getScore().toString())
                                .build()
                );
            });
        }catch (Exception e){
          logger.err("Reddit message provider for "+url, e.getMessage() );
        }

        return posts;
    }



}
