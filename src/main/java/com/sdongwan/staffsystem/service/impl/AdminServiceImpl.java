package com.sdongwan.staffsystem.service.impl;

import com.sdongwan.staffsystem.dao.AdminDao;
import com.sdongwan.staffsystem.entity.Admin;
import com.sdongwan.staffsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public AdminServiceImpl() {
    }

    public boolean isLogin(String adminUserName, String adminUserPwd) {
        boolean flag = false;

        if (adminDao.findByAdminUsernameAndPwd(adminUserName, adminUserPwd).size() > 0) {
            flag = true;
        }

        return flag;
    }


    public List<Admin> showAdmins() {
        return adminDao.findAllAdmin();
    }

    public Admin showByAdminId(Integer id) {
        return adminDao.findByAdminId(id);
    }

    public Admin login(String adminUserName, String adminUserPwd) {
        Admin admin = null;
        if (isLogin(adminUserName, adminUserPwd)) {
            List<Admin> adminList = adminDao.findByAdminUsernameAndPwd(adminUserName, adminUserPwd);
            Iterator<Admin> iterator = adminList.iterator();
            if (iterator.hasNext()) {
                admin = iterator.next();
            }
        }

        return admin;
    }

    public boolean isRegistConflict(Admin admin) {
        boolean flag = true;
        if (adminDao.findByAdminName(admin.getAdminName()).size() == 0) {
            if (adminDao.findByAdminUserName(admin.getAdminUserName()).size() == 0) {
                flag = false;
            }
        }


        return flag;
    }

    public void registAdmin(Admin admin) {
        adminDao.addNewAdmin(admin);
    }

    public void updateAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    public void addLoginCount(Admin admin) {
        List<Admin> admins = adminDao.findByAdminUsernameAndPwd(admin.getAdminUserName(), admin.getAdminPwd());
        admin = admins.get(0);
        admin.setLoginCount(admin.getLoginCount() + 1);
        adminDao.updateAdmin(admin);

    }

}
