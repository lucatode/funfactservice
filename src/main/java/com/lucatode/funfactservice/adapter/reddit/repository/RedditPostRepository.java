package com.lucatode.funfactservice.adapter.reddit.repository;

import com.lucatode.funfactservice.domain.entity.Post;
import com.lucatode.funfactservice.domain.repository.Logger;
import com.lucatode.funfactservice.domain.repository.PostRepository;
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

import static com.mongodb.client.model.Filters.eq;

public class RedditPostRepository implements PostRepository {

  private final String connectionString;
  private final String collectionName;
  private final Logger logger;

  public RedditPostRepository(String connectionString, String collectionName, Logger logger) {
    this.connectionString = connectionString;
    this.collectionName = collectionName;
    this.logger = logger;
  }

  @Override
  public List<Post> GetPosts() {
    MongoClientURI uri = new MongoClientURI(connectionString);
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("funfacts");
    MongoCollection<Document> collection = database.getCollection(collectionName);
    MongoCursor<Document> cursor = collection.find().iterator();

    List<Post> list = new ArrayList<>();

    try {
      while (cursor.hasNext()) {
        final PostBson postBson = new PostBson.PostBsonBuilder().fromDocument(cursor.next()).build();

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

  @Override
  public Post getPostById(String id) {
    try {
      MongoClientURI uri = new MongoClientURI(connectionString);
      MongoClient mongoClient = new MongoClient(uri);
      MongoDatabase database = mongoClient.getDatabase("funfacts");
      MongoCollection<Document> collection = database.getCollection(collectionName);
      Document doc = collection.find(eq("id", id)).first();
      if(doc != null){
        return new PostBson.PostBsonBuilder().fromDocument(doc).build().toPost();
      }
    } catch (Exception e) {
      logger.err("repo", e.getMessage());
    }
    logger.err("repo", "no post retrived");
    return null;
  }

  @Override
  public void pushPost(Post post) {
    try{
      Document document = new PostBson.PostBsonBuilder().fromPost(post).build().toDocument();
      MongoClientURI uri = new MongoClientURI(connectionString);
      MongoClient mongoClient = new MongoClient(uri);
      MongoDatabase database = mongoClient.getDatabase("funfacts");
      MongoCollection<Document> collection = database.getCollection(collectionName);
      collection.insertOne(document);
    }catch (Exception e){
      logger.info("RedditPostRepository", e.getMessage());
    }
  }
}
