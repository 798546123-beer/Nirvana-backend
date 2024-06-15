package com.example.demo.controller;

import com.example.demo.service.serviceImpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class PostController {
    @Autowired
    private PostServiceImpl postService;

}
