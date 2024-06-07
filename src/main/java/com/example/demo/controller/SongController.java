package com.example.demo.controller;

import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.Song;
import com.example.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
