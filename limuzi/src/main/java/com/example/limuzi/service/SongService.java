package com.example.limuzi.service;


import com.example.limuzi.domian.Song;

import java.util.List;

/*
* 歌曲service接口
*/
public interface SongService {
    //增
    public boolean insert(Song song);
    //改
    public boolean update(Song song);
    //删
    public boolean  delete(Integer id);
    //查询
    public Song selectByPrimaryKey(Integer id);
    //查询全部
    public List<Song> allSong();
    //根据歌名精确查询
    public List<Song> songOfName(String name);
    //歌手id查询
    public List<Song> songOfSingerId(Integer singerId);
}
