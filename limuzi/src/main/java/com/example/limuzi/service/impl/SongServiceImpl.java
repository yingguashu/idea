package com.example.limuzi.service.impl;


import com.example.limuzi.dao.SongMapper;
import com.example.limuzi.domian.Song;
import com.example.limuzi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//歌曲service实现类
@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongMapper songMapper;

    //增加
    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song)>0;
    }

    //修改
    @Override
    public boolean update(Song song) {
        return songMapper.update(song)>0;
    }

    //删除
    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id)>0;
    }

    @Override
    public Song selectByPrimaryKey(Integer id) {
        return songMapper.selectByPrimaryKey(id);
    }

    //根据主键查询整个对象
    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    //根据歌手模糊查询
    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }

    //根据歌手id查询
    @Override
    public List<Song> songOfSingerId(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }
}
