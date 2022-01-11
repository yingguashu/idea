package com.example.limuzi.dao;

import com.example.limuzi.domian.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

/*歌曲dao*/
@Repository
public interface SongListMapper {
    //增
    public int insert(SongList songList);
    //改
    public int update(SongList songList);
    //删
    public int delete(Integer id);
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
