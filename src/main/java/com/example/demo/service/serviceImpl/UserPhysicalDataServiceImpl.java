package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.UserPhysicalData;
import com.example.demo.mapper.UserPhysicalDataMapper;
import com.example.demo.service.UserPhysicalDataService;
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
public class UserPhysicalDataServiceImpl extends ServiceImpl<UserPhysicalDataMapper, UserPhysicalData> implements UserPhysicalDataService {
    @Autowired
    UserPhysicalDataMapper userPhysicalDataMapper;
}
