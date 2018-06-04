package com.lucatode.funfactservice.adapter.reddit;

import com.lucatode.funfactservice.adapter.http.DefaultHttpGetClient;
import com.lucatode.funfactservice.adapter.http.HttpGetClient;
import com.lucatode.funfactservice.domain.entity.Post;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RedditMessageProviderTest {

    @Mock
    private HttpGetClient client;

    @Test
    public void getPostList(){


        RedditMessageProvider redditMessageProvider = new RedditMessageProvider(new DefaultHttpGetClient());

        List<Post> list = redditMessageProvider.GetPosts("");

        assertEquals(list.size(), 1);
    }

}
