package com.example.limuzi.service;


import com.example.limuzi.domian.ListSong;

import java.util.List;

/*歌单歌曲Service*/
public interface ListSongService  {

    //增
    public boolean insert(ListSong listSong);
    //改
    public boolean update(ListSong listSong);
    //删
    public boolean delete(Integer id);
    //工具歌曲id和歌单id删除
    public boolean deleteBySongIdAndSongListId(Integer songId,Integer songListId);
    //查询
    public ListSong selectByPrimaryKey(Integer id);
    //查询全部
    public List<ListSong> allListSong();
    //歌单id查询
    public List<ListSong> listSongOfSongListId(Integer songListId);

}
