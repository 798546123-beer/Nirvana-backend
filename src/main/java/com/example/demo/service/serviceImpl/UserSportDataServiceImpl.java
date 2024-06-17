package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.UserSportData;
import com.example.demo.mapper.UserSportDataMapper;
import com.example.demo.service.UserSportDataService;
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
public class UserSportDataServiceImpl extends ServiceImpl<UserSportDataMapper, UserSportData> implements UserSportDataService {
    @Autowired
    UserSportDataMapper userSportDataMapper;
}
