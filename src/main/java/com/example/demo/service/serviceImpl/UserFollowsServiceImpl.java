package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.UserFollows;
import com.example.demo.mapper.UserFollowsMapper;
import com.example.demo.service.UserFollowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zoey
 * \\_/__/
 * @Date: 2024/06/16/22:46
 * @Description:
 */
@Service
public class UserFollowsServiceImpl extends ServiceImpl<UserFollowsMapper, UserFollows> implements UserFollowsService {
    @Autowired
    UserFollowsMapper userFollowsMapper;
}
