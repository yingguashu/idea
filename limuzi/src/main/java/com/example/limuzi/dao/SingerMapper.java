package com.example.limuzi.dao;

import com.example.limuzi.domian.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerMapper {
    //增
    public int insert(Singer singer);
    //改
    public int update(Singer singer);
    //删
    public int delete(Integer id);
    //查询
    public Singer selectByPrimaryKey(Integer id);
    //查询全部
    public List<Singer> allSinger();
    //模糊查询
    public List<Singer> singerOfName(String name);
    //性别查询
    public List<Singer> singerOfSex(Integer sex);

}
