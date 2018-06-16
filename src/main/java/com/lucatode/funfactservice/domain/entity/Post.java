package com.lucatode.funfactservice.domain.entity;

import java.util.Objects;

public class Post {

  private String id;
  private String title;
  private String body;
  private String link;
  private String img;

  public Post() {
  }

  @Override
  public String toString() {
    return "Post{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", body='" + body + '\'' +
            ", link='" + link + '\'' +
            ", img='" + img + '\'' +
            '}';
  }

  public String toJson(){
    return "{\"id\":\""+this.id+"\",\"title\":\""+this.title+"\",\"body\":\""+this.body+"\",\"link\":\""+this.link+"\",\"img\":\""+this.img+"\"}";
  }

  public Post(PostBuilder builder) {
    this.id = builder.id;
    this.title = builder.title;
    this.body = builder.body;
    this.link = builder.link;
    this.img = builder.img;

  }

  public Post(String id, String title, String body, String link, String img) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.link = link;
    this.img = img;
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

  public static class PostBuilder {
    private String id;
    private String title;
    private String body;
    private String link;
    private String img;


    public PostBuilder withId(String id) {
      this.id = id;
      return this;
    }

    public PostBuilder withTitle(String title) {
      this.title = title;
      return this;
    }

    public PostBuilder withBody(String body) {
      this.body = body;
      return this;
    }

    public PostBuilder withLink(String link) {
      this.link = link;
      return this;
    }

    public PostBuilder withImg(String img) {
      this.img = img;
      return this;
    }

    public Post build() {
      return new Post(this);
    }

    public String toJson(){ return ""; }

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Post post = (Post) o;
    return Objects.equals(id, post.id) &&
            Objects.equals(title, post.title) &&
            Objects.equals(body, post.body) &&
            Objects.equals(link, post.link) &&
            Objects.equals(img, post.img);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, title, body, link, img);
  }
}
