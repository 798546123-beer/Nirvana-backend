package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.User;
import com.example.demo.service.serviceImpl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: Zoey
// * @Date: 2024/02/29/8:55
// * @Description:
// */
@RestController
//@Data
@Slf4j
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/findbyuserid")
    public ResponseResult findByUserId(String userId) {
        String user = selectByUserId(userId);
        if (user == null) return ResponseResult.errorResult(506, "用户不存在");
        return ResponseResult.okResult(200, "查询成功", user);
    }

    public String selectByUserId(String userId) {
        User users = userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("userId", userId));
        if (users == null) return null;
        return users.toString();
    }

    @PostMapping("/adduser")
    public ResponseResult addUser(@RequestBody User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        if (!(selectByUserId(user.getUserId()) == null)) {
            return ResponseResult.errorResult(501, "already existed");
        }
        try {
            userService.getBaseMapper().insert(user);
            return ResponseResult.okResult(200, "inserted");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseResult.errorResult(500, "error");
        }

    }
}
