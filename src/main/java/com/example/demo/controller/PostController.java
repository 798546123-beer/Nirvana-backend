package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.service.serviceImpl.PostServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/15
 * @Description:
 */
@RestController
@RequestMapping("/post")
@Api(tags = "post")
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @ApiOperation(value = "查询最近的帖子")
    //后续可以拓展分页
    @GetMapping("/recentPost")
    public ResponseResult selectRecentPost() {
        try {

            List<Post> postList=postService.getBaseMapper().selectList(new QueryWrapper<Post>().eq("status","Published").orderBy(true, false, "publishDate").last("limit 10"));

            if(postList.toString()!="[]"){
                return new ResponseResult<>(200,"查询成功",postList);
            }
            return new ResponseResult<>().error(500,"内容为空!");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseResult<>().error(500,e.toString());
        }
    }
    @ApiOperation(value = "新增post")
    @PostMapping("/addPost")
    public ResponseResult addPost(@RequestBody Post post) {
        try {
            postService.getBaseMapper().insert(new Post(post));
            return ResponseResult.okResult(200,"新增成功");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseResult<>().error(500,e.toString());
        }

    }
    @ApiOperation(value = "删除post")
    @PostMapping("/deletePost")
    public ResponseResult deletePost(String postId) {
        try {
            postService.getBaseMapper().deleteById(postId);
            return ResponseResult.okResult(200,"删除成功");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseResult<>().error(500,e.toString());
        }

    }

}
