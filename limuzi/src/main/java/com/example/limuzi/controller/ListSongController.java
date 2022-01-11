package com.example.limuzi.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.limuzi.domian.ListSong;
import com.example.limuzi.service.ListSongService;
import com.example.limuzi.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Integer.parseInt;

//歌单歌曲管理controller
@RestController
@RequestMapping("/listSong")
public class ListSongController {

    @Autowired
    private ListSongService listSongService;

    //添加歌单的歌曲
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addListSong(HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String songId = request.getParameter("songId").trim();//歌曲id
        String songListId = request.getParameter("songListId").trim();//歌单id
        ListSong listSong = new ListSong();
        listSong.setSongId(Integer.parseInt(songId));
        listSong.setSongListId(Integer.parseInt(songListId));
        boolean flag = listSongService.insert(listSong);
        if (flag) {
            jsonObject.put(Consts.CODE, 1);
            jsonObject.put(Consts.MSG, "保存成功");
            return jsonObject;
        }
        jsonObject.put(Consts.CODE, 0);
        jsonObject.put(Consts.MSG, "保存失败");
        return jsonObject;
    }

    /*根据歌单id查询*/
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Object detail(HttpServletRequest request) {
        String songListId = request.getParameter("songListId");
        return listSongService.listSongOfSongListId(parseInt(songListId));
    }

    /*删除歌单里面的歌曲*/
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object delete(HttpServletRequest request) {
        //-TODO 先查询到数据库中对应的文件地址，删除掉它在进行下面的代码
        String songId = request.getParameter("songId").trim();
        String songListId = request.getParameter("songListId").trim();
        boolean flag = listSongService.deleteBySongIdAndSongListId(parseInt(songId), parseInt(songListId));
        return flag;
    }
}
