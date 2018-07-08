package com.lucatode.funfactservice.adapter.reddit.repository;

import com.lucatode.funfactservice.domain.entity.Post;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class PostBson {
     @BsonProperty("id")    private final String id;
     @BsonProperty("title") private final String title;
     @BsonProperty("body")  private final String body;
     @BsonProperty("link")  private final String link;
     @BsonProperty("img")   private final String img;

    @BsonCreator
    public PostBson(
            @BsonProperty("id")   String id,
            @BsonProperty("title")String title,
            @BsonProperty("body") String body,
            @BsonProperty("link") String link,
            @BsonProperty("img")  String img) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.link = link;
        this.img = img;
    }


    public Document toDocument(){
        return new Document("id", id)
                .append("title",title)
                .append("body", body)
                .append("link", link)
                .append("img", img);

    }

    public static final class PostBsonBuilder {
        private String id;
        private String title;
        private String body;
        private String link;
        private String img;

        private PostBsonBuilder() {
        }

        public static PostBsonBuilder aPostBson() {
            return new PostBsonBuilder();
        }

        public PostBsonBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public PostBsonBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public PostBsonBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public PostBsonBuilder withLink(String link) {
            this.link = link;
            return this;
        }

        public PostBsonBuilder withImg(String img) {
            this.img = img;
            return this;
        }

        public PostBsonBuilder fromPost(Post post){
            this.id = post.getId();
            this.body = post.getBody();
            this.title = post.getTitle();
            this.img = post.getImg();
            this.link = post.getLink();
            return this;
        }

        public PostBson build() {
            return new PostBson(id, title, body, link, img);
        }
    }
}
