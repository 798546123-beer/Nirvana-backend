package com.example.demo.controller;

import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.UserPhysicalData;
import com.example.demo.service.AnalyticsReportService;
import com.example.demo.service.UserPhysicalDataService;
import com.example.demo.service.serviceImpl.UserPhysicalDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/17
 * @Description:
 */
@RestController
@RequestMapping("/userphysicaldata")
public class UserPhysicalDataController {
    @Autowired
    private UserPhysicalDataServiceImpl userPhysicalDataService;
    public String selectByUserId(String userId) {
        UserPhysicalData  userPhysicalData = userPhysicalDataService.getById(userId);
        if(userPhysicalData == null) return null;
        return userPhysicalData.toString();
    }
    @GetMapping("/findByUserId")
    public ResponseResult findByUserId(String userId) {
        String userPhysicalData = selectByUserId(userId);
        if(userPhysicalData == null)
            return ResponseResult.errorResult(404,"用户不存在");
        else
            return ResponseResult.okResult(200,"查找成功",userPhysicalData);
    }
    //更新身体数据
    @PostMapping("/update")
    public ResponseResult updateUserPhysicalData(UserPhysicalData userPhysicalData) {
        if(userPhysicalDataService.updateById(userPhysicalData))
            return ResponseResult.okResult(200,"更新成功");
        else
            return ResponseResult.errorResult(404,"更新失败");
    }
    //新增身体数据
    @PostMapping("/upload")
    public ResponseResult add(@RequestBody UserPhysicalData userPhysicalData){
        try{
            userPhysicalDataService.getBaseMapper().insert(new UserPhysicalData(userPhysicalData));
            return ResponseResult.okResult(200,"新增数据成功");
        }catch(Exception e){
            System.out.println(e);
            return ResponseResult.errorResult(500,"新增数据失败");
        }
    }

}

