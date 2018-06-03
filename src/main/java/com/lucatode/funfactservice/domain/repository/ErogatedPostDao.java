package com.lucatode.funfactservice.domain.repository;

import com.lucatode.funfactservice.domain.entity.Post;

import java.util.List;

public interface ErogatedPostDao {

    List<Post> GetErogatePosts();
    void StoreErogatedPost(Post post);

}
