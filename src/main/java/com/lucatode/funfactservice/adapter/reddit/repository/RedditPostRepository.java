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

import static com.mongodb.client.model.Filters.eq;

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

    List<Post> list = new ArrayList<>();

    try {
      while (cursor.hasNext()) {
        final PostBson postBson = PostBson.PostBsonBuilder.aPostBson().fromDocument(cursor.next()).build();

        list.add(postBson.toPost());
      }
    } finally {
      cursor.close();
    }

    return list;
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
      MongoClientURI uri = new MongoClientURI(connectionString);
      MongoClient mongoClient = new MongoClient(uri);
      MongoDatabase database = mongoClient.getDatabase("funfacts");
      MongoCollection<Document> collection = database.getCollection("erogatedPosts");
      Document doc = collection.find(eq("id", id)).first();
      if(doc != null){
        return PostBson.PostBsonBuilder.aPostBson().fromDocument(doc).build().toPost();
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
