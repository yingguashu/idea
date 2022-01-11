package com.example.limuzi.dao;

import com.example.limuzi.domian.ListSong;
import org.springframework.stereotype.Repository;

import java.util.List;

/*歌单歌曲dao*/
@Repository
public interface ListSongMapper {
    //增
    public int insert(ListSong listSong);
    //改
    public int update(ListSong listSong);
    //删
    public int delete(Integer id);
    //工具歌曲id和歌单id删除
    public int deleteBySongIdAndSongListId(Integer songId,Integer songListId);
    //查询
    public ListSong selectByPrimaryKey(Integer id);
    //查询全部
    public List<ListSong> allListSong();
    //歌单id查询
    public List<ListSong> listSongOfSongListId(Integer songListId);

}
