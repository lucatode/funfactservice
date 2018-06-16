package com.lucatode.funfactservice.adapter.reddit.repository;

import com.lucatode.funfactservice.adapter.http.HttpGetClient;
import com.lucatode.funfactservice.adapter.http.HttpPostClient;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RedditErogatedPostRepository {


  private final HttpGetClient getClient;
  private final HttpPostClient postClient;
  private final Logger logger;

  public RedditErogatedPostRepository(HttpGetClient getClient, HttpPostClient postClient, Logger logger) {
    this.getClient = getClient;
    this.postClient = postClient;
    this.logger = logger;
  }

  public List<Post> GetPosts() {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<Post[]> typeRef = new TypeReference<Post[]>() {
    };
    String callResult = getClient.getGetCallResult();
      String unwrapped = callResult.substring(1,callResult.length()-1);
    final String[] split = unwrapped.split("\\{(.*?)\\}");
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for (String s : split) {
      unwrapped = unwrapped.replace(s, "");
    }
    unwrapped = unwrapped.replace("}{", "},{");
    stringBuilder.append(unwrapped);
    stringBuilder.append("]");
    Post[] posts = new Post[0];
    try {
      posts = mapper.readValue(stringBuilder.toString(), typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if(posts != null){
      return Arrays.asList(posts);
    }else{
      return null;
    }
  }

  public Post getPostById(String id) {
    try {
      final List<Post> posts = GetPosts();
      final List<Post> collect = posts.stream().filter(i -> i.getId().equals(id)).collect(Collectors.toList());
      if(collect.size() == 1){
        return collect.get(0);
      }

    } catch (Exception e) {
      logger.err("repo", e.getMessage());
    }
    logger.err("repo", "no post retrived");
    return null;
  }

  public void trackErogatedPost(Post toErogate) {
    try{
      postClient.postJson(toErogate.toJson());
    }catch (Exception e){
      //
    }
  }
}
