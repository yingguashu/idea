package com.example.demod.dao;

import com.example.demod.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    List<Admin> finAll();
    Integer add(Admin admin);
}
