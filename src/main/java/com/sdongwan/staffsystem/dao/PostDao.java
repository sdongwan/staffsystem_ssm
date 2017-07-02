package com.sdongwan.staffsystem.dao;

import com.sdongwan.staffsystem.entity.Post;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface PostDao {
    void insertPost(Post post);

    void updatePost(Post post);

    void delPost(Post post);

    List<Post> findAllPost();

    Post finnByPostId(Integer id);

    List<Post> findByPostName(String postName);
}
