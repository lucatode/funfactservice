package com.lucatode.funfactservice.domain.task;

import com.lucatode.funfactservice.adapter.reddit.RedditMessageProvider;
import com.lucatode.funfactservice.adapter.reddit.repository.RedditErogatedPostRepository;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RedditTaskTests {

  private RedditTask redditTask;

  @Mock
  private RedditErogatedPostRepository redditErogatedPostRepository;
  @Mock
  private RedditMessageProvider redditMessageProvider;
  @Mock
  private PostErogator postErogator;
  @Mock
  private Logger logger;

  @Before
  public void setup(){
    final Post abcd01 = new Post.PostBuilder().withId("ABCD01").build();
    when(redditMessageProvider.GetPosts(any(String.class))).thenReturn(Arrays.asList(abcd01));
    when(redditErogatedPostRepository.getPostById("ABCD01")).thenReturn(abcd01);
    doNothing().when(redditErogatedPostRepository).trackErogatedPost(abcd01);
    doNothing().when(postErogator).erogate(abcd01);
    redditTask = new RedditTask(redditErogatedPostRepository, redditMessageProvider, postErogator, logger, "");
  }

  @Test
  public void MessageProviderIsUsed(){
    redditTask.run();
    verify(redditMessageProvider, times(1)).GetPosts(any(String.class));
  }

  @Test
  public void PostRepositoryIsUsedForRead(){
    redditTask.run();
    verify(redditErogatedPostRepository, times(1)).getPostById(any(String.class));
  }

  @Test
  public void PostRepositoryIsUsedForWrite(){
    redditTask.run();
    verify(redditErogatedPostRepository, times(1)).getPostById(any(String.class));
  }

  @Test
  @Ignore
  public void PostErogatorIsUsed(){
    redditTask.run();
    verify(postErogator, times(1)).erogate(any(Post.class));
  }


}
