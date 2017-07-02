package com.sdongwan.staffsystem.mapper;

import com.sdongwan.staffsystem.entity.Admin;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public interface AdminMapper {
    List<Admin> findAllAdmin();

    List<Admin> findByAdminUsernameAndPwd(String adminUserName, String adminUserPwd);


    Admin findByAdminId(Integer adminId);

    void addNewAdmin(Admin admin);

    List<Admin> findByAdminName(String adminName);

    List<Admin> findByAdminUserName(String adminUserName);

    void updateAdmin(Admin admin);


}
