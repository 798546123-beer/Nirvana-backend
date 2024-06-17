package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.WorkoutData;
import com.example.demo.mapper.WorkoutDataMapper;
import com.example.demo.service.WorkoutDataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/17
 * @Description:
 */
@Service
public class WorkoutDataServiceImpl extends ServiceImpl<WorkoutDataMapper, WorkoutData> implements WorkoutDataService{
    @Autowired
    WorkoutDataMapper workoutDataMapper;
}
