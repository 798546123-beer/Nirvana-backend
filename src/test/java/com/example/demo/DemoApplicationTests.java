package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.service.serviceImpl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
@Autowired
private UserMapper userMapper;
	@Test
	void contextLoads() {
//		System.out.println(userMapper.selectById(2).toString());
	}

}
