package com.lucatode.funfactservice.domain.task;

import com.lucatode.funfactservice.adapter.reddit.RedditMessageProvider;
import com.lucatode.funfactservice.adapter.reddit.repository.RedditPostRepository;
import com.lucatode.funfactservice.domain.PostErogator;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class RedditTask extends TimerTask {

  private RedditPostRepository redditErogatedPostRepository;
  private RedditPostRepository redditPostPoolRepository;
  private RedditMessageProvider redditMessageProvider;
  private PostErogator postErogator;
  private Logger logger;
  private final String url;

  @Autowired
  public RedditTask(
          RedditPostRepository redditErogatedPostRepository,
          RedditPostRepository redditPostPoolRepository,
          RedditMessageProvider redditMessageProvider,
          PostErogator postErogator, Logger logger, String url)
  {
    this.redditErogatedPostRepository = redditErogatedPostRepository;
    this.redditPostPoolRepository = redditPostPoolRepository;
    this.redditMessageProvider = redditMessageProvider;
    this.postErogator = postErogator;
    this.logger = logger;
    this.url = url;
  }

  @Override
  public void run() {
    logger.info("Reddit Task", "Starting Reddit Task");

    final List<Post> posts = redditMessageProvider.GetPostsByUps(url);
    ErogateAPost(posts);
    SaveOnPool(posts);
  }

  private void SaveOnPool(List<Post> posts) {
    posts.stream()
            .filter(p -> redditPostPoolRepository.getPostById(p.getId()) == null)
            .limit(5)
            .forEach(p -> redditPostPoolRepository.pushPost(p));
  }

  private void ErogateAPost(List<Post> posts){
    for (Post post : posts) {
      if(redditErogatedPostRepository.getPostById(post.getId()) == null){
        postErogator.erogate(post);
        redditErogatedPostRepository.pushPost(post);
        logger.info("Reddit Task", "Post erogated");
        break;
      }
    }
  }
}
