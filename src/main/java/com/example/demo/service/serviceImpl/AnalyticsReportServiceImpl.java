package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.AnalyticsReport;
import com.example.demo.mapper.AnalyticsReportMapper;
import com.example.demo.service.AnalyticsReportService;
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
public class AnalyticsReportServiceImpl extends ServiceImpl<AnalyticsReportMapper, AnalyticsReport> implements AnalyticsReportService {
    @Autowired
    public AnalyticsReportMapper analyticsReportMapper;
}
