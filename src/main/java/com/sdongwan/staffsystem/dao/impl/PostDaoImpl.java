package com.sdongwan.staffsystem.dao.impl;

import com.sdongwan.staffsystem.dao.PostDao;
import com.sdongwan.staffsystem.entity.Post;
import com.sdongwan.staffsystem.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private PostMapper postMapper;

    public PostMapper getPostMapper() {
        return postMapper;
    }

    public void setPostMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public PostDaoImpl() {
    }

    public void insertPost(Post post) {
        postMapper.insertPost(post);
    }

    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }

    public void delPost(Post post) {
        postMapper.delPost(post);
    }

    public List<Post> findAllPost() {
        return postMapper.findAllPost();
    }

    public Post finnByPostId(Integer id) {
        return postMapper.findByPostId(id);
    }

    public List<Post> findByPostName(String postName) {
        return postMapper.findByPostName(postName);
    }
}
