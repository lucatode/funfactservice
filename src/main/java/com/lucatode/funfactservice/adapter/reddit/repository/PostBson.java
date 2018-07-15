package com.lucatode.funfactservice.adapter.reddit.repository;

import com.lucatode.funfactservice.domain.entity.Post;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;

public class PostBson {
    @BsonProperty("id")
    private String id;
    @BsonProperty("title")
    private String title;
    @BsonProperty("body")
    private String body;
    @BsonProperty("link")
    private String link;
    @BsonProperty("img")
    private String img;
    @BsonProperty("type")
    private String type;
    @BsonProperty("subreddit")
    private String subreddit;
    @BsonProperty("timeStamp")
    private Date timeStamp;
    @BsonProperty("score")
    private String score;

    @BsonCreator
    public PostBson(
            @BsonProperty("id") String id,
            @BsonProperty("title") String title,
            @BsonProperty("body") String body,
            @BsonProperty("link") String link,
            @BsonProperty("img") String img,
            @BsonProperty("type") String type,
            @BsonProperty("subreddit") String subreddit,
            @BsonProperty("timeStamp") Date timeStamp,
            @BsonProperty("score") String score
    ) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.link = link;
        this.img = img;
        this.type = type;
        this.subreddit = subreddit;
        this.timeStamp = timeStamp;
        this.score = score;
    }

    @BsonCreator
    public PostBson() {
    }

    private PostBson(PostBsonBuilder postBsonBuilder) {
        id = postBsonBuilder.id;
        title = postBsonBuilder.title;
        body = postBsonBuilder.body;
        link = postBsonBuilder.link;
        img = postBsonBuilder.img;
        type = postBsonBuilder.type;
        subreddit = postBsonBuilder.subreddit;
        timeStamp = postBsonBuilder.timeStamp;
        score = postBsonBuilder.score;
    }


    public Document toDocument() {
        return new Document("id", id)
                .append("title", title)
                .append("body", body)
                .append("link", link)
                .append("img", img)
                .append("type", type)
                .append("subreddit", subreddit)
                .append("timeStamp", timeStamp)
                .append("score", score);

    }

    public Post toPost() {
        return new Post.PostBuilder()
                .withId(id)
                .withTitle(title)
                .withBody(body)
                .withImg(img)
                .withLink(link)
                .withType(type)
                .withSubreddit(subreddit)
                .withTimeStamp(timeStamp)
                .withScore(score)
                .build();
    }


    public static final class PostBsonBuilder {
        private String id;
        private String title;
        private String body;
        private String link;
        private String img;
        private String type;
        private String subreddit;
        private Date timeStamp;
        private String score;

        public PostBsonBuilder() {
        }

        public PostBsonBuilder withId(String val) {
            id = val;
            return this;
        }

        public PostBsonBuilder withTitle(String val) {
            title = val;
            return this;
        }

        public PostBsonBuilder withBody(String val) {
            body = val;
            return this;
        }

        public PostBsonBuilder withLink(String val) {
            link = val;
            return this;
        }

        public PostBsonBuilder withImg(String val) {
            img = val;
            return this;
        }

        public PostBsonBuilder withType(String val) {
            type = val;
            return this;
        }

        public PostBsonBuilder withSubreddit(String val) {
            subreddit = val;
            return this;
        }

        public PostBsonBuilder withTimeStamp(Date val) {
            timeStamp = val;
            return this;
        }

        public PostBsonBuilder withScore(String val) {
            subreddit = val;
            return this;
        }

        public PostBsonBuilder fromPost(Post post){
            id = post.getId();
            title = post.getTitle();
            body = post.getBody();
            link = post.getLink();
            img = post.getImg();
            type = post.getType();
            subreddit = post.getSubreddit();
            timeStamp = post.getTimeStamp();
            score = post.getScore();
            return this;
        }

        public PostBsonBuilder fromDocument(Document doc) {
            this.id = (String) doc.get("id");
            this.body = (String) doc.get("body");
            this.title = (String) doc.get("title");
            this.img = (String) doc.get("img");
            this.link = (String) doc.get("link");
            this.type = (String) doc.get("type");
            this.subreddit = (String) doc.get("subreddit");
            this.timeStamp = (Date) doc.get("timeStamp");
            this.score = (String) doc.get("score");
            return this;
        }

        public PostBson build() {
            return new PostBson(this);
        }
    }
}
