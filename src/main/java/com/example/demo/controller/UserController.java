package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.User;
import com.example.demo.service.serviceImpl.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
@RestController
@Slf4j
@RequestMapping("/user")
@Api(tags = "user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @ApiOperation(value = "查找用户")
    @GetMapping("/findByUserId")
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
    @ApiOperation(value = "新增用户")
    @PostMapping("/addUser")
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

    public Boolean addCaresNumber(String caresId){
    User users=userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("userId",caresId));
    if(users==null){
        return false;
    }else {
        try{
            users.setCares(users.getCares()+1);
            userService.getBaseMapper().updateById(users);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
    }
    public Boolean addFollowsNumber(String followsId){
        User users=userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("userId",followsId));
        if(users==null){
            return false;
        }else {
            try{
                users.setFollows(users.getFollows()+1);
                userService.getBaseMapper().updateById(users);
                return true;
            }catch (Exception e){
                System.out.println(e);
                return false;
            }
        }
    }
}
