package com.example.limuzi.service;


import com.example.limuzi.domian.SongList;

import java.util.List;

/*歌单接口*/
public interface SongListService {
    //增
    public boolean insert(SongList songList);
    //改
    public boolean update(SongList songList);
    //删
    public boolean delete(Integer id);
    //查询
    public SongList selectByPrimaryKey(Integer id);
    //查询全部
    public List<SongList> allSongList();
    //根据标题精确查询
    public List<SongList> songListOfTitle(String title);
    //根据标题模糊查询
    public List<SongList> likeTitle(String title);
    //根据风格查询
    public List<SongList> likeStyle(String style);

}
