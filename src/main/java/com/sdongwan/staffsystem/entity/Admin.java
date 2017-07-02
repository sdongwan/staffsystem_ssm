package com.sdongwan.staffsystem.entity;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/9.
 */

public class Admin implements Serializable {


    private static final long serialVersionUID = -7929277156658455318L;

    private Integer adminId;
    @Size(min = 2, max = 10, message = "管理员名字不能为空")
    private String adminName;
    @NotBlank(message = "管理员用户名不能为空")
    private String adminUserName;
    @NotBlank
    private String adminPwd;


    private Integer loginCount;

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Admin() {


    }

    public Admin(Integer adminId, String adminName, String adminUserName, String adminPwd) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminUserName = adminUserName;
        this.adminPwd = adminPwd;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminUserName='" + adminUserName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                '}';
    }
}
