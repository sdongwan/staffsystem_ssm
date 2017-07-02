package com.sdongwan.staffsystem.service;

import com.sdongwan.staffsystem.entity.Admin;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface AdminService {
    boolean isLogin(String adminUserName, String adminUserPwd);

    List<Admin> showAdmins();

    Admin showByAdminId(Integer id);

    Admin login(String adminUserName, String adminUserPwd);

    boolean isRegistConflict(Admin admin);

    void registAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void addLoginCount(Admin admin);
}
