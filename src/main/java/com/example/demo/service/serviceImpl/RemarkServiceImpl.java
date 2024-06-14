package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.Remark;
import com.example.demo.mapper.RemarkMapper;
import com.example.demo.service.RemarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/14
 * @Description:
 */

@Service
public class RemarkServiceImpl extends ServiceImpl<RemarkMapper, Remark> implements RemarkService {
    @Autowired
    private RemarkMapper remarkMapper;
}
