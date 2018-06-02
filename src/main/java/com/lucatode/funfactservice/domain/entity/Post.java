package com.lucatode.funfactservice.domain.entity;

public class Post {

    private final String id;
    private final String title;
    private final String body;
    private final String link;
    private final String img;

    public Post(PostBuilder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.body = builder.body;
        this.link = builder.link;
        this.img = builder.img;

    }
    private Post(String id, String title, String body, String link, String img) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.link = link;
        this.img = img;
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
    }
}
