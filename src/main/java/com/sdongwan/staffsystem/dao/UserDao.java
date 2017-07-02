package com.sdongwan.staffsystem.dao;

import com.sdongwan.staffsystem.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface UserDao {
    void insertUser(User user);

    void delUser(User user);

    void updateUser(User user);

    User findByUserId(Integer userId);

    List<User> findByUserName(String UserName);

    List<User> findByPostId(Integer postId);

    List<User> findAllUser();

    List<User> findAllUserByPage(int pageNo, int pageSize);

    int getUserCount();

    int getPostUserCount(Integer postId);
}
