package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


//@Component("UserServiceImpl")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;

    public void addUser(String userId, String username, String password, String email, String gender, String userType, Integer follows, Integer cares) {
        userMapper.insert(new User(userId, username, password, email, gender, userType, follows, cares));
    }
//    @Override
//    public User selectBySno(String Sno) {
//        return userMapper.selectById(new QueryWrapper<User>().eq("Sno", Sno));
//    }
//    public void delUser(String Sno) {
//        userMapper.deleteById(Sno);
//    }

//
//    @Override
//    public int insert(User entity) {
//        return 0;
//    }
//
//    @Override
//    public int deleteById(Serializable id) {
//        return 0;
//    }
//
//    @Override
//    public int deleteById(User entity) {
//        return 0;
//    }
//
//    @Override
//    public int deleteByMap(Map<String, Object> columnMap) {
//        return 0;
//    }


//    @Override
//    public boolean save(User entity) {
//        return super.save(entity);
//    }

//
//    @Override
//    public Long selectCount(Wrapper<User> queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public List<User> selectAll(Wrapper<User> queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public List<Map<String, Object>> selectMaps(Wrapper<User> queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public List<Object> selectObjs(Wrapper<User> queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public <P extends IPage<User>> P selectPage(P page, Wrapper<User> queryWrapper) {
//        return null;
//    }
//
//    @Override
//    public <P extends IPage<Map<String, Object>>> P selectMapsPage(P page, Wrapper<User> queryWrapper) {
//        return null;
//    }


}
