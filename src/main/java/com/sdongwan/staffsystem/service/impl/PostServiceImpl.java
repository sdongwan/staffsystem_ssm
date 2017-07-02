package com.sdongwan.staffsystem.service.impl;

import com.sdongwan.staffsystem.dao.PostDao;
import com.sdongwan.staffsystem.entity.Post;
import com.sdongwan.staffsystem.entity.User;
import com.sdongwan.staffsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    public PostServiceImpl() {
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }


    public void addPost(Post post) {
        postDao.insertPost(post);
    }

    public void delPost(Post post) {
        postDao.delPost(post);
    }

    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    public Post showByPostId(Integer postId) {
        return postDao.finnByPostId(postId);
    }

    public List<Post> showPosts() {
        return postDao.findAllPost();
    }

    public List<Post> showByPostName(String postName) {
        return postDao.findByPostName(postName);
    }


    public boolean isExist(String postName) {
        boolean flag = false;
        if (showByPostName(postName).size() > 0) {
            flag = true;
        }


        return flag;
    }

    public boolean isUpdate(Post post) {
        boolean flag = false;
        List<Post> posts = showByPostName(post.getPostName());
        if (showByPostName(post.getPostName()).size() > 0) {
            for (Post p : showByPostName(post.getPostName())) {
                if (p.getPostId() == post.getPostId()) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean isDel(Integer postId) {
        boolean flag = true;
        if (showByPostId(postId).getPostNum() > 0) {
            flag = false;
        }

        return flag;
    }

    public int getPostUserCount(Integer postId) {
        int count = 0;
        Set<User> set = postDao.finnByPostId(postId).getUsers();
        count = set.size();
        return count;
    }
}
