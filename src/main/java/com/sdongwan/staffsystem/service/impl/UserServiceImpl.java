package com.sdongwan.staffsystem.service.impl;

import com.sdongwan.staffsystem.dao.UserDao;
import com.sdongwan.staffsystem.entity.User;
import com.sdongwan.staffsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.insertUser(user);
    }

    public void delUser(User user) {
        userDao.delUser(user);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User showByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }

    public List<User> showUsers() {
        return userDao.findAllUser();
    }


    public List<User> showByUserName(String userName) {
        return userDao.findByUserName(userName);
    }

    public boolean isExist(String userName) {
        boolean flag = false;
        if (userDao.findByUserName(userName).size() > 0) {
            flag = true;
        }
        return flag;
    }


    public boolean isUpdate(User user) {
        boolean flag = false;
        if (showByUserName(user.getUsername()).size() > 0) {

            for (User u : showByUserName(user.getUsername())) {
                if (u.getUserId().equals(user.getUserId())) {
                    flag = true;
                }
            }
        } else {
            flag = false;
        }

        return flag;
    }

    public List<User> showUsersByPage(int pageNo, int pageSize) {

        return userDao.findAllUserByPage(pageNo, pageSize);
    }

    public int getUserCount() {
        return userDao.getUserCount();
    }
}
