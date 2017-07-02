package com.sdongwan.staffsystem.dao.impl;

import com.sdongwan.staffsystem.dao.AdminDao;
import com.sdongwan.staffsystem.entity.Admin;
import com.sdongwan.staffsystem.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    private AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public AdminDaoImpl() {
    }

    public List<Admin> findAllAdmin() {


        return adminMapper.findAllAdmin();
    }

    public List<Admin> findByAdminUsernameAndPwd(String adminUserName, String adminUserPwd) {
        return adminMapper.findByAdminUsernameAndPwd(adminUserName, adminUserPwd);
    }

    public Admin findByAdminId(Integer adminId) {
        return adminMapper.findByAdminId(adminId);
    }

    public void addNewAdmin(Admin admin) {
        adminMapper.addNewAdmin(admin);
    }

    public List<Admin> findByAdminName(String adminName) {
        return adminMapper.findByAdminName(adminName);
    }

    public List<Admin> findByAdminUserName(String adminUserName) {
        return adminMapper.findByAdminUserName(adminUserName);
    }

    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }


}
