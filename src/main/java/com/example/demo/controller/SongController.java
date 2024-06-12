package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.Song;
import com.example.demo.Entity.User;
import com.example.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import javax.smartcardio.ResponseAPDU;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zoey
 * \\_/__/
 * @Date: 2024/06/07/12:39
 * @Description:
 */
@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;
    @PostMapping("/upload")
    public ResponseResult add(@RequestBody Song song) {
        try {
            songService.getBaseMapper().insert(new Song(song));
            return ResponseResult.okResult(200, "inserted");
        }catch(Exception e){
            System.out.println(e);
            return ResponseResult.errorResult(500, "error");
        }
    }
    public String selectBySongId(String songId) {
        Song song = songService.getBaseMapper().selectOne(new QueryWrapper<Song>().eq("songId", songId));
        if (song == null) return null;
        return song.toString();
    }
    @PostMapping("/delete")
    public ResponseResult delete(@RequestParam String songId){
        if ((selectBySongId(songId) == null)) {
            return ResponseResult.errorResult(404, "song not found");
        }
        try{
            songService.getBaseMapper().delete(new QueryWrapper<Song>().eq("songId", songId));
            return ResponseResult.okResult(200, "deleted");
        }catch (Exception e) {
            System.out.println(e);
            return ResponseResult.errorResult(500, "error");
        }
    }

}
