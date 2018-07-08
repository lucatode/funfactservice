package com.lucatode.funfactservice.adapter.reddit.repository;

import com.lucatode.funfactservice.adapter.http.HttpGetClient;
import com.lucatode.funfactservice.adapter.http.HttpPostClient;
import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RedditPostRepository {

  private final String connectionString;
  private final Logger logger;

  public RedditPostRepository(String connectionString, Logger logger) {
    this.connectionString = connectionString;
    this.logger = logger;
  }

  public List<Post> GetPosts() {
    MongoClientURI uri = new MongoClientURI(connectionString);
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("funfacts");
    MongoCollection<Document> collection = database.getCollection("erogatedPosts");
    MongoCursor<Document> cursor = collection.find().iterator();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    try {
      while (cursor.hasNext()) {
        stringBuilder.append(cursor.next().toJson());
        stringBuilder.append(",");
      }
    } finally {
      stringBuilder.deleteCharAt( stringBuilder.length() - 1 );
      cursor.close();
    }
    stringBuilder.append("]");
    return convertToPosts(stringBuilder.toString());
  }

  private List<Post> convertToPosts(String postsJson) {
    ObjectMapper mapper = new ObjectMapper();
    TypeReference<Post[]> typeRef = new TypeReference<Post[]>() {
    };
    Post[] posts = new Post[0];
    try {
      posts = mapper.readValue(postsJson, typeRef);
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

  public void pushPost(Post post) {
    try{
      Document document = PostBson.PostBsonBuilder.aPostBson().fromPost(post).build().toDocument();
      MongoClientURI uri = new MongoClientURI(connectionString);
      MongoClient mongoClient = new MongoClient(uri);
      MongoDatabase database = mongoClient.getDatabase("funfacts");
      MongoCollection<Document> collection = database.getCollection("erogatedPosts");
      collection.insertOne(document);
    }catch (Exception e){
      //
    }
  }
}
