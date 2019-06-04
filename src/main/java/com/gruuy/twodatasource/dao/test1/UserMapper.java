package com.gruuy.twodatasource.dao.test1;

import com.gruuy.twodatasource.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<SysUser> getUser();
}
