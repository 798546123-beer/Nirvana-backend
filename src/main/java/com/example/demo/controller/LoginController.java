package com.example.demo.controller;

import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.User;
import com.example.demo.service.serviceImpl.UserServiceImpl;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserController userController;
    @PostMapping("/login")
    public ResponseResult login(@RequestParam("userId") String userId,
                                @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
        User users = userService.getBaseMapper().selectOne(new QueryWrapper<User>().eq("userId",userId));
        String result=userController.selectByUserId(userId);
        if(result==null){
            //用户名不存在
            return ResponseResult.errorResult(506,"用户名不存在");
        }
        String pw=users.getPassword();
        if(!StringUtils.isEmpty(userId)&&password.equals(pw)){
            session.setAttribute("userId", userId);
//            return "redirect:/index.html";
            return new ResponseResult(200,"登陆成功",users);
        }
        else {
            map.put("msg","用户名或密码错误");
            return ResponseResult.errorResult(505,"账号或密码错误");
        }
    }
}
