package com.example.demod.service;

import com.example.demod.pojo.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> finAll();
    Integer add(Admin admin);
}
