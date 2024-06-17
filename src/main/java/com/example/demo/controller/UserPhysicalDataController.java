package com.example.demo.controller;

import com.example.demo.service.AnalyticsReportService;
import com.example.demo.service.UserPhysicalDataService;
import com.example.demo.service.serviceImpl.UserPhysicalDataServiceImpl;
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
@RequestMapping("/userphysicaldata")
public class UserPhysicalDataController {
    @Autowired
    private UserPhysicalDataServiceImpl userPhysicalDataService;
}

