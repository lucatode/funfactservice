package com.lucatode.funfactservice.adapter.reddit.repository;

import com.lucatode.funfactservice.adapter.http.DefaultHttpGetClient;
import com.lucatode.funfactservice.domain.entity.Post;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RedditErogatedPostRepository {


    private final DefaultHttpGetClient client;
    private final String url;

    public RedditErogatedPostRepository(DefaultHttpGetClient client, String url) {
        this.client = client;
        this.url = url;
    }

    public List<Post> GetPosts() throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        TypeReference<HashMap<String,Post>> typeRef = new TypeReference<HashMap<String,Post>>() {};
//
//        HashMap<String,Post> o = mapper.readValue(client.getGetCallResult(url), typeRef);
        return new ArrayList<>();
    }

}
