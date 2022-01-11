package com.example.limuzi.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    /*验证密码*/
     int verifyPassword(String username,String password);
}
