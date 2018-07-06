package com.lucatode.funfactservice;

import com.lucatode.funfactservice.adapter.dispatcher.PostDispatcher;
import com.lucatode.funfactservice.adapter.http.DefaultHttpGetClient;
import com.lucatode.funfactservice.adapter.http.DefaultHttpPostClient;
import com.lucatode.funfactservice.adapter.logger.FirebaseLogger;
import com.lucatode.funfactservice.adapter.reddit.RedditMessageProvider;
import com.lucatode.funfactservice.adapter.reddit.repository.RedditPostRepository;
import com.lucatode.funfactservice.domain.PostErogator;
import com.lucatode.funfactservice.domain.repository.Logger;
import com.lucatode.funfactservice.domain.task.RedditTask;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class FunFactServiceApplication {


  public static void main(String[] args) throws Exception {

    Map<String, String> env = System.getenv();
    String POSTS_POOL_REPOSITORY = env.get("POSTS_POOL_REPOSITORY");
    String EROGATED_POSTS_REPOSITORY = env.get("EROGATED_POSTS_REPOSITORY");
    String REDDIT_POSTS_TARGET = env.get("REDDIT_POSTS_TARGET");
    String CHANNEL_URL = env.get("CHANNEL_URL");
    String LOGGER_URL = env.get("CHANNEL_URL");

    Logger logger = new FirebaseLogger(new DefaultHttpPostClient(LOGGER_URL));
    logger.info("[MAIN]","Start");

    RedditPostRepository redditPoolRepository = new RedditPostRepository(
            new DefaultHttpGetClient(POSTS_POOL_REPOSITORY),
            new DefaultHttpPostClient(POSTS_POOL_REPOSITORY), logger);

    RedditPostRepository redditErogatedPostRepository = new RedditPostRepository(
            new DefaultHttpGetClient(EROGATED_POSTS_REPOSITORY),
            new DefaultHttpPostClient(EROGATED_POSTS_REPOSITORY), logger);

    RedditMessageProvider redditMessageProvider = new RedditMessageProvider(
            new DefaultHttpGetClient(REDDIT_POSTS_TARGET), logger);

    PostErogator postErogator = new PostDispatcher(
            new DefaultHttpPostClient(CHANNEL_URL), logger, "reddit");

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    scheduler.scheduleAtFixedRate(
            new RedditTask(
                    redditErogatedPostRepository,
                    redditPoolRepository,
                    redditMessageProvider,
                    postErogator,
                    logger,
                    REDDIT_POSTS_TARGET
            ),
            0,
            30,
            TimeUnit.MINUTES
    );
  }

}
