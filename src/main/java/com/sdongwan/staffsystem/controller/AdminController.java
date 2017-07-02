package com.sdongwan.staffsystem.controller;

import com.sdongwan.staffsystem.entity.Admin;
import com.sdongwan.staffsystem.service.AdminService;
import com.sdongwan.staffsystem.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Administrator on 2017/6/29.
 */
@Controller
public class AdminController {


    @Autowired
    private AdminService adminService;

    public AdminController() {
    }

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }


    //    修改value=/login.jsp 使用这个url访问会出现错误，不能使用后缀名
    @RequestMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("admin", new Admin());

        return "login";
    }


    @RequestMapping(value = "/toRegistAdmin")
    public String toRegistAdmin(Model model) {
        model.addAttribute("admin", new Admin());

        return "/WEB-INF/registAdmin";
    }

    @RequestMapping(value = "/registAdmin")
    public String registAdmin(@Valid Admin admin, BindingResult bindingResult, HttpSession session) {

        System.out.println(admin);
        if (admin.getAdminPwd() == null) {
            System.out.println("pwd null");
        }

        if (admin.getAdminUserName() == null) {
            System.out.println("username null");
        }

        if (admin.getAdminName() == null) {
            System.out.println("name null");
        }

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());

            return "/WEB-INF/registAdmin";

        } else {
            System.out.println("no error");
        }

        if (!adminService.isRegistConflict(admin)) {
            admin.setLoginCount(0);
            adminService.registAdmin(admin);
            admin = adminService.login(admin.getAdminUserName(), admin.getAdminPwd());
            session.setAttribute("admin", admin);
            return "/WEB-INF/admin/index";
        } else {
            bindingResult.addError(new ObjectError("error", "管理员名字或用户名重复"));
            return "/WEB-INF/registAdmin";
        }

    }


    @RequestMapping(value = "/adminValide")
    public String adminLogin(Admin admin, BindingResult bindingResult, Model model, HttpSession session) {

        LoginValidator loginValidator = new LoginValidator();
        loginValidator.validate(admin, bindingResult);
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            System.out.println(fieldError.getCode() + " " + fieldError.getDefaultMessage() + " ");


            return "login";
        }


        if (adminService.isLogin(admin.getAdminUserName(), admin.getAdminPwd())) {

            adminService.addLoginCount(admin);
//            model.addAttribute("admin", admin);
            admin = adminService.login(admin.getAdminUserName(), admin.getAdminPwd());
            session.setAttribute("admin", admin);
            return "WEB-INF/admin/index";
        } else {

            //自己灵活的定制输出错误，第一个参数是path=adminPwd ，第二个参数是code（message中的对应的code），第三个参数是默认的信息
            bindingResult.rejectValue("adminPwd", "adminUserName.requird", "用户不存在");

            return "login";
        }

    }


    @RequestMapping(value = "/admin/toUpdateAdmin")
    public String toUpdateAdmin(HttpSession session, Model model) {
        Admin admin = (Admin) session.getAttribute("admin");
        model.addAttribute("admin", admin);

        return "/WEB-INF/admin/updateAdmin";
    }

    @RequestMapping(value = "/admin/updateAdmin")
    public String updateAdmin(@ModelAttribute Admin admin, HttpSession session) {
        System.out.println(admin);

        adminService.updateAdmin(admin);

        session.setAttribute("admin", admin);

        return "/WEB-INF/admin/index";
    }


    @RequestMapping(value = "/admin/toBackAdmin")
    public String toBack() {

        return "/WEB-INF/admin/main";
    }


    @RequestMapping(value = "/admin/header")
    public String toHeader() {

        return "/WEB-INF/admin/header";
    }

    @RequestMapping(value = "/admin/menu")
    public String toMenu() {

        return "/WEB-INF/admin/menu";
    }


    @RequestMapping(value = "/admin/main")
    public String toMain() {

        return "/WEB-INF/admin/main";
    }


    @RequestMapping(value = "/admin/footer")
    public String toFooter() {
        System.out.println("footer");
        return "/WEB-INF/admin/footer";
    }

    @RequestMapping(value = "/admin/logout")
    public String toLogout() {

        return "/WEB-INF/admin/logout";
    }


}
