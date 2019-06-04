package com.gruuy.twodatasource.dao.test2;

import com.gruuy.twodatasource.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Test2UserMapper {
    List<SysUser> getUser();
}
