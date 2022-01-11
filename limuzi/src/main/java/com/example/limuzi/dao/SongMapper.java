package com.example.limuzi.dao;

import com.example.limuzi.domian.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
/*歌曲dao*/
@Repository
public interface SongMapper {
    //增
    public int insert(Song song);
    //改
    public int update(Song song);
    //删
    public int delete(Integer id);
    //查询
    public Song selectByPrimaryKey(Integer id);
    //查询全部
    public List<Song> allSong();
    //根据歌名精确查询
    public List<Song> songOfName(String name);
    //歌手id查询
    public List<Song> songOfSingerId(Integer singerId);

}
