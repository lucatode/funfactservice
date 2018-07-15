package com.lucatode.funfactservice.domain.repository;

import com.lucatode.funfactservice.domain.entity.Post;

import java.util.List;

public interface PostRepository {
    List<Post> GetPosts();

    Post getPostById(String id);

    void pushPost(Post post);
}
