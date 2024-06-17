package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.Entity.WorkoutData;
import com.example.demo.service.WorkoutDataService;
import com.example.demo.service.serviceImpl.WorkoutDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/17
 * @Description:
 */
@RestController
@RequestMapping("/workoutdata")
public class WorkoutDataController {
    @Autowired
    private WorkoutDataServiceImpl workoutDataService;
//上传
    @PostMapping("/upload")
    public ResponseResult add(WorkoutData workoutData) {
        try{
            workoutDataService.getBaseMapper().insert(new WorkoutData(workoutData));
            return ResponseResult.okResult(200,"运动数据上传成功");
        }catch(Exception e){
            return ResponseResult.errorResult(500,"运动数据上传失败");
        }
    }
//按id查询
    @PostMapping("/findByWorkoutDataId")
    public ResponseResult findByWorkoutDataId(String workoutDataId) {
        try{
            WorkoutData workoutData = workoutDataService.getBaseMapper().selectById(workoutDataId);
            return ResponseResult.okResult(200,"查询成功",workoutData.toString());
        }catch(Exception e){
            return ResponseResult.errorResult(500,"查询失败");
        }
    }
//按用户查询
    public List<WorkoutData> selectByUserId(String userId) {
        List workoutData = workoutDataService.getBaseMapper().selectList(new QueryWrapper<WorkoutData>().eq("userId",userId));
        if(workoutData.isEmpty()) return null;
        return workoutData;
    }
    @PostMapping("/findByUserId")
    public ResponseResult findByUserId(String userId) {
        List<WorkoutData> workoutData = selectByUserId(userId);
        if(workoutData == null)
            return ResponseResult.errorResult(500,"用户不存在或用户无运动数据");
        return new ResponseResult(200,"查询成功",workoutData);
    }
//更新数据
}
