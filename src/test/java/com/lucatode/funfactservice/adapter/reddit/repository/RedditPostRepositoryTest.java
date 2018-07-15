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
import java.util.Map;

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
    Map<String, String> env = System.getenv();

    repo = new RedditPostRepository(env.get("EROGATED_POSTS_REPOSITORY"),"erogatedPosts", logger);
  }

  @Test
  public void pushPostOnRepo() throws IOException {

    repo.pushPost(new Post.PostBuilder().withId("1").withTitle("Title").withBody("Body").withImg("img").withLink("Link").withScore("12345").build());
//    List<Post> posts = repo.GetPosts();
//    assertEquals(1,posts.size());
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
      Post post = repo.getPostById("8x3l2r");
      assertEquals("Mistakes were made.", post.getTitle());
  }


}
