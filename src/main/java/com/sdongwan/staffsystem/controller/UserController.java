package com.sdongwan.staffsystem.controller;

import com.sdongwan.staffsystem.entity.User;
import com.sdongwan.staffsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    public UserController() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/user/showUsers")
    public String showUsers(Model model) {
        List<User> users = userService.showUsers();
        model.addAttribute("users", users);

        return "/WEB-INF/user/showUsers";
    }


    @RequestMapping(value = "/user/toAddUser")
    public String toAddUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/WEB-INF/user/addUser";
    }

    @RequestMapping(value = "/user/addUser")
    public String addUser(User user, Model model, HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("utf-8");
        List<MultipartFile> files = user.getImages();
        System.out.println(files);
        List<String> filenames = new ArrayList<String>();
        if (files != null && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                String fileNameOrigin = multipartFile.getOriginalFilename();
                String suffix = fileNameOrigin.substring(fileNameOrigin.lastIndexOf("."));
                System.out.println(suffix);
                String fileName = System.currentTimeMillis() + suffix;
                File imageFile = new File(request.getServletContext().getRealPath("/upload"), fileName);
                user.setPhoto(fileName);
                multipartFile.transferTo(imageFile);
            }

        } else {
            user.setPhoto("default.png");
        }


        System.out.println("adduser " + user);

        userService.addUser(user);

        List<User> users = userService.showUsers();
        model.addAttribute("users", users);

        return "/WEB-INF/user/showUsers";

    }

    @RequestMapping(value = "/user/delUser")
    public String delUser(@RequestParam int userId, Model model) {
        User user = userService.showByUserId(userId);
        userService.delUser(user);
        List<User> users = userService.showUsers();
        model.addAttribute("users", users);
        return "/WEB-INF/user/showUsers";
    }

    @RequestMapping(value = "/user/toUpUser")
    public String toUpUser(@RequestParam int userId, Model model) {
        User user = userService.showByUserId(userId);
        model.addAttribute("user", user);

        return "/WEB-INF/user/upUser";
    }

    @RequestMapping(value = "/user/upUser")
    public String updateUser(Model model, User user) {
        userService.updateUser(user);
        List<User> users = userService.showUsers();
        model.addAttribute("users", users);
        return "/WEB-INF/user/showUsers";
    }

}
