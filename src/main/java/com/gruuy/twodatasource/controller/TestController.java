package com.gruuy.twodatasource.controller;

import com.gruuy.twodatasource.entity.SysUser;
import com.gruuy.twodatasource.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public List<SysUser> test(){
        return userService.getUserList();
    }
    @RequestMapping("/test2")
    public List<SysUser> test2(){
        return userService.gettest2UserList();
    }
}
