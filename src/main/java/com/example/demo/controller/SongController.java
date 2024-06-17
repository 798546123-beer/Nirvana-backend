package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.Song;
import com.example.demo.service.SongService;
import com.example.demo.service.serviceImpl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    private SongServiceImpl songService;

    @PostMapping("/upload")
    public ResponseResult add(@RequestBody Song song) {
        try {
            songService.getBaseMapper().insert(new Song(song));
            return ResponseResult.okResult(200, "inserted");
        } catch (Exception e) {
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
    public ResponseResult delete(@RequestParam String songId) {
        if ((selectBySongId(songId) == null)) {
            return ResponseResult.errorResult(404, "song not found");
        }
        try {
            songService.getBaseMapper().delete(new QueryWrapper<Song>().eq("songId", songId));
            return ResponseResult.okResult(200, "deleted");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseResult.errorResult(500, "error");
        }
    }

    public List<Song> selectAll() {
        try {
            List<Song> songList = songService.getBaseMapper().selectList(null);
            return songList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @GetMapping("/selectAll")
    public ResponseResult findAll() {
        List<Song> songList = selectAll();
        if (songList != null) {
            return new ResponseResult(200, "查询成功", songList);
        } else {
            return ResponseResult.errorResult(500, "未找到");
        }
    }

    public List<Song> selectByTag(String tag) {
        try {
            List<Song> songList = songService.getBaseMapper().selectList(new QueryWrapper<Song>().like("tags", tag));
            return songList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }


    @GetMapping("/selectByTags")
    public ResponseResult findByTag(String tag) {
        List<Song> songList = selectByTag(tag);
        if (songList == null)
            return new ResponseResult(500, "没有对应的歌曲!");
        else return new ResponseResult(200,"查询成功",songList);
    }

}
