package com.example.limuzi.service.impl;

import com.example.limuzi.dao.AdminMapper;
import com.example.limuzi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override //验证密码
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username, password)>0;
    }
}
