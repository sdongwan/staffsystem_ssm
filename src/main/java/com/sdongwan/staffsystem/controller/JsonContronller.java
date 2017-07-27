package com.sdongwan.staffsystem.controller;

import com.sdongwan.staffsystem.entity.Post;
import com.sdongwan.staffsystem.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

/**
 * Created by Administrator on 2017/7/25.
 */

@Controller
public class JsonContronller {
    @RequestMapping("/getJson")
    @ResponseBody   //返回json数据，使用ResponseBody注解
    public Object getJsonData() {
        User user = new User();
        user.setName("sdongwan");
        user.setSex("boy");
        user.setBirthday(new Date(20170202l));
        user.setPostId(1);
        user.setPost(new Post("java开发", 10, "长的帅气", null));
        return user;

    }


}
