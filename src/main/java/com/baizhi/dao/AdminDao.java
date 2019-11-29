package com.baizhi.dao;

import com.baizhi.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao {
    @Select("select * from admin where name=#{name} and password=#{password}")
    public Admin selectByNameAndPwd(@Param("name") String name, @Param("password") String password);
}
