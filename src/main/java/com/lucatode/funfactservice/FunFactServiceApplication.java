package com.lucatode.funfactservice;

import com.lucatode.funfactservice.adapter.dispatcher.PostDispatcher;
import com.lucatode.funfactservice.adapter.http.DefaultHttpGetClient;
import com.lucatode.funfactservice.adapter.http.DefaultHttpPostClient;
import com.lucatode.funfactservice.adapter.logger.FirebaseLogger;
import com.lucatode.funfactservice.adapter.reddit.RedditMessageProvider;
import com.lucatode.funfactservice.adapter.reddit.repository.RedditErogatedPostRepository;
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

  private static String EROGATED_POSTS_REPOSITORY = "https://xxxxxxxxxxxxx.firebaseio.com/erogated_posts.json";
  private static String REDDIT_POSTS_TARGET = "https://www.reddit.com/r/MemeEconomy/new.json";
  private static String CHANNEL_URL = "https://xxxxxxxxxxxxxxxxxxxxx/notify/reddit";
  private static String LOGGER_URL = "https://xxxxxxxxxxxxx.firebaseio.com/reddit_logger.json";

  public static void main(String[] args) throws Exception {

    Map<String, String> env = System.getenv();
    EROGATED_POSTS_REPOSITORY = env.get(EROGATED_POSTS_REPOSITORY);
    REDDIT_POSTS_TARGET = env.get(REDDIT_POSTS_TARGET);
    CHANNEL_URL = env.get(CHANNEL_URL);
    LOGGER_URL = env.get(LOGGER_URL);

    Logger logger = new FirebaseLogger(new DefaultHttpPostClient(LOGGER_URL));
    logger.info("[MAIN]","Start");
    RedditErogatedPostRepository redditErogatedPostRepository = new RedditErogatedPostRepository(
            new DefaultHttpGetClient(EROGATED_POSTS_REPOSITORY),
            new DefaultHttpPostClient(EROGATED_POSTS_REPOSITORY), logger);
    RedditMessageProvider redditMessageProvider = new RedditMessageProvider(new DefaultHttpGetClient(REDDIT_POSTS_TARGET), logger);

    PostErogator postErogator = new PostDispatcher(new DefaultHttpPostClient(CHANNEL_URL), logger, "reddit");

    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    scheduler.scheduleAtFixedRate(
            new RedditTask(redditErogatedPostRepository, redditMessageProvider, postErogator, REDDIT_POSTS_TARGET),
            0,
            30,
            TimeUnit.MINUTES
    );
  }

}
