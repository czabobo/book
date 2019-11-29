package com.baizhi.dao;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from user where name=#{name} and password=#{password}")
    public User selectByNameAndPwd(@Param("name") String name, @Param("password") String password);
}
