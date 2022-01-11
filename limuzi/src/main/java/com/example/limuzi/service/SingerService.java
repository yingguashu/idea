package com.example.limuzi.service;


import com.example.limuzi.domian.Singer;

import java.util.List;

public interface SingerService {
    //+
    public boolean insert(Singer singer);
    //gai
    public boolean update(Singer singer);
    //删
    public boolean delete(Integer id);
    //查询
    public Singer selectByPrimaryKey(Integer id);
    //查询quanbu
    public List<Singer> allSinger();
    //mohu查询
    public List<Singer> singerOfName(String name);
    //sex查询
    public List<Singer> singerOfSex(Integer sex);
}
