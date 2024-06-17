package com.example.demo.controller;

import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.UserFollows;
import com.example.demo.service.serviceImpl.UserFollowsServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.UserController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zoey
 * \\_/__/
 * @Date: 2024/06/16/20:56
 * @Description:
 */
@RestController
@Api(tags = "FollowsAndCares")
public class FollowsAndCaresController {
    @Autowired
    private UserFollowsServiceImpl userFollowsService;
    @Autowired
    private UserController userController;
    public Boolean insertCares(String caresId,String followsId){
        try {
            userFollowsService.getBaseMapper().insert(new UserFollows(caresId,followsId));
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    @GetMapping("/user/follow")
    @Transactional(rollbackFor = Exception.class)
    public ResponseResult care(@RequestParam String caresId,@RequestParam  String followsId){
        try{
           if((insertCares(caresId,followsId))&&userController.addCaresNumber(followsId)&&userController.addFollowsNumber(caresId))
               return new ResponseResult(200,"关注成功");
           else {
               return ResponseResult.errorResult(500,"关注失败");
           }
        }catch(Exception e){
            System.out.println(e);
            return ResponseResult.errorResult(500,"关注失败");
        }
    }
}
