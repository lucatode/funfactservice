package com.lucatode.funfactservice.adapter.reddit.repository;

import com.lucatode.funfactservice.adapter.http.HttpGetClient;
import com.lucatode.funfactservice.adapter.http.HttpPostClient;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RedditPostRepositoryTest {

  @Mock
  private HttpGetClient client;
  @Mock
  private HttpPostClient postClient;
  @Mock
  private Logger logger;

  private RedditPostRepository repo;

  @Before
  public void setup() throws IOException {
    when(client.getGetCallResult()).thenReturn(POST_LIST_JSON_EXAMPLE);
    repo = new RedditPostRepository(client, postClient, logger);
  }

  @Test
  public void getPostsFromRepository() throws IOException {

    List<Post> posts = repo.GetPosts();
    assertEquals(2,posts.size());
  }

  @Test
  public void verifyPostNameWhenRetrivedFromRepo() throws IOException {

    List<Post> posts = repo.GetPosts();
    Post p = posts.get(0);
    assertEquals("8qskdm",p.getId());
  }

  @Test
  public void getPostById(){
    String unwrapped = POST_LIST_JSON_EXAMPLE.substring(1,POST_LIST_JSON_EXAMPLE.length()-1);
    final String[] split = unwrapped.split("\\{(.*?)\\}");
    assertEquals(2, split.length);
  }

  private static String POST_LIST_JSON_EXAMPLE = "{\"-LEu3r6zdnzI0xXrmJ7W\":{\"body\":\"\",\"id\":\"8qskdm\",\"img\":\"\",\"link\":\"https://i.imgur.com/hSBelsc.gifv\",\"title\":\"I think he's okay\"},\"-LEz8XJJtmn1Tysuejn5\":{\"body\":\"\",\"id\":\"8r26on\",\"img\":\"\",\"link\":\"https://gfycat.com/WelllitWildAcornwoodpecker\",\"title\":\"Everybody down!\"}}";

}
