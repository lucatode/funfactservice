package com.lucatode.funfactservice.adapter.dispatcher;

import com.lucatode.funfactservice.adapter.http.DefaultHttpPostClient;
import com.lucatode.funfactservice.domain.PostErogator;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PostDispatcherTest {

  private static String CHANNEL_URL = "https:/xxxxxxxxxx.xxx.xxx/notify/reddit";

  @Mock
  private Logger logger;

  @Test
  public void IT()
  {
    PostErogator postErogator = new PostDispatcher(new DefaultHttpPostClient(CHANNEL_URL), logger, "reddit");
    postErogator.erogate(new Post.PostBuilder().withLink("test").build());
  }

}