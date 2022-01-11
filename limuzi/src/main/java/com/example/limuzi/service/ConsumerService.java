package com.example.limuzi.service;


import com.example.limuzi.domian.Consumer;

import java.util.List;

//前端用户Service接口

public interface ConsumerService {
    //增
    public boolean insert(Consumer consumer);
    //改
    public boolean update(Consumer consumer);
    //删
    public boolean delete(Integer id);
    //查询
    public Consumer selectByPrimaryKey(Integer id);
    //查询全部
    public List<Consumer> allConsumer();
    /*验证密码*/
    public boolean verifyPassword(String username,String password);
    /*根据用户名查询*/
    public Consumer getByUsername(String username);
}
