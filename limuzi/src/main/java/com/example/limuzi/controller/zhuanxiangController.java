package com.example.limuzi.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.limuzi.domian.SongList;
import com.example.limuzi.service.ListSongService;
import com.example.limuzi.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 */
@Controller
public class zhuanxiangController {
    @Autowired
    private SongListService songListService;
    @Autowired
    private ListSongService listSongService;

    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(HttpSession session, String name){
        System.out.println("这是测试");
        session.setAttribute("name",name);
        return "index";
    }
    @RequestMapping("/allSongList")
    public String allSongList(HttpSession session){
        List<SongList> songLists= songListService.allSongList();
        String all = JSONObject.toJSONString(songLists);
        session.setAttribute("song",JSONObject.toJSONString(songLists));
        System.out.println((String) session.getAttribute("song"));
        return "song";
    }

}
