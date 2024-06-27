package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.Song;
import com.example.demo.service.SongService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;


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
    @Transactional(rollbackFor = Exception.class)
    @PostMapping("/upload")
    public ResponseResult add(@RequestBody Song song) {

        try {
            songService.getBaseMapper().insert(new Song(song));//imgUrl还没加
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

    @GetMapping("/selectBySongId")
    public ResponseResult findBySongId(@RequestParam String songId) {
        Song song = songService.getBaseMapper().selectOne(new QueryWrapper<Song>().eq("songId", songId));
        return song == null ? (new ResponseResult(500, "没有找到对应的歌曲")) : (new ResponseResult<>(200, "查找成功", song));
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

    @GetMapping("/recommend")
    public ResponseResult recommend(@RequestParam String num) {
        @AllArgsConstructor
        class byTag{
            public String tag;
            public List<Song> list;
        }
        List<byTag> list=new ArrayList<>();
        List<String> tags=null;
        if(num.equals("1")||num.equals("5"))
        tags = Arrays.asList("流行", "伤感", "emo");//"流行"
        else if(num.equals("2")||num.equals("4")) {
        tags = Arrays.asList("燃", "h3r3", "温暖");
        }else{
        tags = Arrays.asList("伤感", "节奏", "emo");
        }
        tags.forEach(tag -> {
            List<Song> songList = songService.getBaseMapper().selectList(new QueryWrapper<Song>().like("tags", tag));
            list.add(new byTag(tag,songList));
        });
        //没加try catch
        return new ResponseResult<>(200,"查询成功",list);
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
    public ResponseResult findByTag(@RequestParam String tag) {
        List<Song> songList = selectByTag(tag);
        if (songList == null)
            return new ResponseResult(500, "没有对应的歌曲!");
        else return new ResponseResult(200, "查询成功", songList);
    }

    @ApiOperation(value = "模糊查找歌曲")
    @CrossOrigin
    @GetMapping("/selectByFuzzy")
    public ResponseResult findByFuzzy(@RequestParam String word) {
        try {
            List<Song> songList = songService.getBaseMapper().selectList(new QueryWrapper<Song>().like("title", word));
            System.out.println(songList.toString());
            if (songList.toString() != "[]") {
                return new ResponseResult(200, "查询成功", songList);
            } else return ResponseResult.errorResult(500, "没有类似的歌曲!");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseResult().error(500, e.toString());
        }
    }

    @ApiOperation(value = "播放次数+1")
    @CrossOrigin
    @GetMapping("/addPlayCount")
    public ResponseResult addPlayCount(@RequestParam String songId) {
        try {
            Song song = songService.getBaseMapper().selectOne(new QueryWrapper<Song>().eq("songId", songId));
            song.setPlayCount(song.getPlayCount() + 1);
            songService.getBaseMapper().update(song, new QueryWrapper<Song>().eq("songId", songId));
            return ResponseResult.okResult(200, "播放次数+1");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseResult.errorResult(500, "更新失败");
        }
    }

}
