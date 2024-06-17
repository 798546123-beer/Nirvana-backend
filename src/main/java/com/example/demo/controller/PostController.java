package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.service.serviceImpl.PostServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            List<Post> postList=postService.getBaseMapper().selectList(new QueryWrapper<Post>().eq("status","Published").orderBy(true, true, "publishDate").last("limit 10"));
            if(postList.toString()!="[]"){
                return new ResponseResult<>(200,"查询成功",postList);
            }
            return new ResponseResult<>().error(500,"内容为空!");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseResult<>().error(500,e.toString());
        }
    }

}
