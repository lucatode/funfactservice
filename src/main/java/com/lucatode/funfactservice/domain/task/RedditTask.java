package com.lucatode.funfactservice.domain.task;

import com.lucatode.funfactservice.adapter.reddit.RedditMessageProvider;
import com.lucatode.funfactservice.adapter.reddit.repository.RedditErogatedPostRepository;
import com.lucatode.funfactservice.domain.PostErogator;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.TimerTask;

public class RedditTask extends TimerTask {

  private RedditErogatedPostRepository redditErogatedPostRepository;
  private RedditMessageProvider redditMessageProvider;
  private PostErogator postErogator;
  private Logger logger;
  private final String url;

  @Autowired
  public RedditTask(
          RedditErogatedPostRepository redditErogatedPostRepository,
          RedditMessageProvider redditMessageProvider,
          PostErogator postErogator, Logger logger, String url)
  {
    this.redditErogatedPostRepository = redditErogatedPostRepository;
    this.redditMessageProvider = redditMessageProvider;
    this.postErogator = postErogator;
    this.logger = logger;
    this.url = url;
  }

  @Override
  public void run() {
    logger.info("Reddit Task", "Starting Reddit Task");

    final List<Post> posts = redditMessageProvider.GetPosts(url);
    for (Post post : posts) {
      if(redditErogatedPostRepository.getPostById(post.getId()) == null){
        postErogator.erogate(post);
        redditErogatedPostRepository.trackErogatedPost(post);
        logger.info("Reddit Task", "Post erogated");
        break;
      }

    }



  }
}
