package com.lucatode.funfactservice.domain.task;

import com.lucatode.funfactservice.adapter.http.DefaultHttpGetClient;
import com.lucatode.funfactservice.adapter.reddit.RedditMessageProvider;
import com.lucatode.funfactservice.adapter.reddit.repository.RedditPostRepository;
import com.lucatode.funfactservice.domain.PostErogator;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RedditTaskTests {

  private RedditTask redditTask;

  @Mock
  private RedditPostRepository redditPostRepository;
  @Mock
  private RedditPostRepository redditPostPoolRepository;
  @Mock
  private RedditMessageProvider redditMessageProvider;
  @Mock
  private PostErogator postErogator;
  @Mock
  private Logger logger;

  @Before
  public void setup(){
    final Post abcd01 = new Post.PostBuilder().withId("ABCD01").build();
    when(redditMessageProvider.GetPostsByUps(any(String.class))).thenReturn(Arrays.asList(abcd01));
    when(redditPostRepository.getPostById("ABCD01")).thenReturn(abcd01);
    doNothing().when(redditPostRepository).pushPost(abcd01);
    doNothing().when(postErogator).erogate(abcd01);
    redditTask = new RedditTask(redditPostRepository, redditPostPoolRepository, redditMessageProvider, postErogator, logger, "");
  }

  @Test
  public void MessageProviderIsUsed(){
    redditTask.run();
    verify(redditMessageProvider, times(1)).GetPostsByUps(any(String.class));
  }

  @Test
  public void PostRepositoryIsUsedForRead(){
    redditTask.run();
    verify(redditPostRepository, times(1)).getPostById(any(String.class));
  }

  @Test
  public void PostRepositoryIsUsedForWrite(){
    redditTask.run();
    verify(redditPostRepository, times(1)).getPostById(any(String.class));
  }

  @Test
  public void SaveOnPool(){
    Map<String, String> env = System.getenv();
    String POSTS_POOL_REPOSITORY = env.get("POSTS_POOL_REPOSITORY");
    RedditMessageProvider redditMessageProviderIT = new RedditMessageProvider(new DefaultHttpGetClient("https://www.reddit.com/r/gifs/new.json"), logger);
    RedditPostRepository redditPoolRepositoryIT = new RedditPostRepository(POSTS_POOL_REPOSITORY,"postPool", logger);
    redditTask = new RedditTask(redditPostRepository, redditPoolRepositoryIT, redditMessageProviderIT, postErogator, logger, "");
    redditTask.run();

    assertEquals(5,redditPoolRepositoryIT.GetPosts().size());
  }

  @Test
  @Ignore
  public void PostErogatorIsUsed(){
    redditTask.run();
    verify(postErogator, times(1)).erogate(any(Post.class));
  }


}
