package com.lucatode.funfactservice.domain.entity;

import java.util.Date;

public class Post {

  private String id;
  private String title;
  private String body;
  private String link;
  private String img;
  private String type;
  private String subreddit;
  private Date timeStamp;
  private String score;

  public Post(PostBuilder postBuilder) {
    id = postBuilder.id;
    title = postBuilder.title;
    body = postBuilder.body;
    link = postBuilder.link;
    img = postBuilder.img;
    type = postBuilder.type;
    subreddit = postBuilder.subreddit;
    timeStamp = postBuilder.timeStamp;
    score = postBuilder.score;
  }

  @Override
  public String toString() {
    return "Post{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", body='" + body + '\'' +
            ", link='" + link + '\'' +
            ", img='" + img + '\'' +
            ", type='" + type + '\'' +
            ", subreddit='" + subreddit + '\'' +
            ", timeStamp=" + timeStamp +
            ", score='" + score + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public String getLink() {
    return link;
  }

  public String getImg() {
    return img;
  }

  public String getType() {
    return type;
  }

  public String getSubreddit() {
    return subreddit;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public String getScore() {
    return score;
  }

  public static final class PostBuilder {
    private String id;
    private String title;
    private String body;
    private String link;
    private String img;
    private String type;
    private String subreddit;
    private Date timeStamp;
    private String score;

    public PostBuilder() {
    }

    public PostBuilder withId(String val) {
      id = val;
      return this;
    }

    public PostBuilder withTitle(String val) {
      title = val;
      return this;
    }

    public PostBuilder withBody(String val) {
      body = val;
      return this;
    }

    public PostBuilder withLink(String val) {
      link = val;
      return this;
    }

    public PostBuilder withImg(String val) {
      img = val;
      return this;
    }

    public PostBuilder withType(String val) {
      type = val;
      return this;
    }

    public PostBuilder withSubreddit(String val) {
      subreddit = val;
      return this;
    }

    public PostBuilder withTimeStamp(Date val) {
      timeStamp = val;
      return this;
    }

    public PostBuilder withScore(String score) {
      this.score = score;
      return this;
    }

    public Post build() {
      return new Post(this);
    }


  }
}