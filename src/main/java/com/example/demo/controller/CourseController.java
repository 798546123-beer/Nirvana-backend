package com.example.demo.controller;

import com.example.demo.service.serviceImpl.CourseServiceImpl;
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
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

}
