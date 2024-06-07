package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Zoey
 * @Date: 2024/05/22/11:06
 * @Description:
 */
@Mapper
//@Repository
//@Component
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from c1")
//    public List<User> findAll();
}
