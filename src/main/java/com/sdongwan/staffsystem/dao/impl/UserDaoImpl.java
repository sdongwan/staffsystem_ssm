package com.sdongwan.staffsystem.dao.impl;

import com.sdongwan.staffsystem.dao.UserDao;
import com.sdongwan.staffsystem.entity.User;
import com.sdongwan.staffsystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserDaoImpl() {
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public void delUser(User user) {
        userMapper.delUser(user);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public User findByUserId(Integer userId) {
        return userMapper.findByUserId(userId);
    }

    public List<User> findByUserName(String UserName) {
        return userMapper.findByUserName(UserName);
    }

    public List<User> findByPostId(Integer postId) {
        return userMapper.findByPostId(postId);
    }

    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    public List<User> findAllUserByPage(int pageNo, int pageSize) {
        return userMapper.findAllUserByPage(pageNo, pageSize);
    }

    public int getUserCount() {
        return userMapper.getUserCount();
    }

    public int getPostUserCount(Integer postId) {
        return userMapper.getPostUserCount(postId);
    }

}
