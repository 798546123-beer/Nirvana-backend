package com.example.demo.controller;

import com.example.demo.service.AnalyticsReportService;
import com.example.demo.service.serviceImpl.AnalyticsReportServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/analysticsreport")
public class AnalyticsReportController {
    @Autowired
    private AnalyticsReportServiceImpl analyticsReportService;
}
