package com.example.demo.controller;

import com.example.demo.service.WorkoutDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private WorkoutDataService workoutDataService;
}
