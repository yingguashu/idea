package com.example.demod.service.impl;

import com.example.demod.dao.AdminMapper;
import com.example.demod.pojo.Admin;
import com.example.demod.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> finAll() {
        return adminMapper.finAll();
    }

    @Override
    public Integer add(Admin admin) {
        return adminMapper.add(admin);
    }
}
