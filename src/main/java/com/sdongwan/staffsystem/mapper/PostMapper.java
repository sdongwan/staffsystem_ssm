package com.sdongwan.staffsystem.mapper;

import com.sdongwan.staffsystem.entity.Post;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface PostMapper {
    void insertPost(Post post);

    void updatePost(Post post);

    void delPost(Post post);

    List<Post> findAllPost();

    Post findByPostId(Integer id);

    List<Post> findByPostName(String postName);
}
