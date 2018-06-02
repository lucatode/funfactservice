package com.lucatode.funfactservice.domain;

import com.lucatode.funfactservice.domain.entity.Post;

import java.util.List;

public interface MessageProvider {

    List<Post> GetPosts();
}
