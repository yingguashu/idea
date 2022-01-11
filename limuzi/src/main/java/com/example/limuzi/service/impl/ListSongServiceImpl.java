package com.example.limuzi.service.impl;

import com.example.limuzi.dao.ListSongMapper;
import com.example.limuzi.domian.ListSong;
import com.example.limuzi.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*歌单歌曲的实现类*/
@Service
public class ListSongServiceImpl implements ListSongService {
    @Autowired
    private ListSongMapper listsongMapper;

    @Override
    public boolean insert(ListSong listSong) {
        return listsongMapper.insert(listSong)>0;
    }

    @Override
    public boolean update(ListSong listSong) {
        return listsongMapper.update(listSong)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return listsongMapper.delete(id)>0;
    }

    @Override
    public boolean deleteBySongIdAndSongListId(Integer songId, Integer songListId) {
        return listsongMapper.deleteBySongIdAndSongListId(songId,songListId)>0;
    }

    @Override
    public ListSong selectByPrimaryKey(Integer id) {
        return listsongMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ListSong> allListSong() {
        return listsongMapper.allListSong();
    }

    @Override
    public List<ListSong> listSongOfSongListId(Integer songListId) {
        return listsongMapper.listSongOfSongListId(songListId);
    }
}
