package com.example.limuzi.dao;

import com.example.limuzi.domian.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

/*前端用户*/
@Repository
public interface ConsumerMapper {
    //增
    public int insert(Consumer consumer);
    //改
    public int update(Consumer consumer);
    //删
    public int delete(Integer id);
    //查询
    public Consumer selectByPrimaryKey(Integer id);
    //查询全部
    public List<Consumer> allConsumer();
    /*验证密码*/
    public int verifyPassword(String username,String password);
    /*根据用户名查询*/
    public Consumer getByUsername(String username);

}
