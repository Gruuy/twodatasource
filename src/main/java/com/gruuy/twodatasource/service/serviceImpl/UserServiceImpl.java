package com.gruuy.twodatasource.service.serviceImpl;

import com.gruuy.twodatasource.dao.test1.UserMapper;
import com.gruuy.twodatasource.dao.test2.Test2UserMapper;
import com.gruuy.twodatasource.datasource.DS;
import com.gruuy.twodatasource.entity.SysUser;
import com.gruuy.twodatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    Test2UserMapper test2UserMapper;

    @Override
    @DS("test1")
    public List<SysUser> getUserList() {
        return userMapper.getUser();
    }
    @Override
    @DS("test2")
    public List<SysUser> gettest2UserList(){
        return test2UserMapper.getUser();
    }
}
