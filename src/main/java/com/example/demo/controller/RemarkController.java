package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.Remark;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.service.serviceImpl.RemarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/14
 * @Description:
 */
@RestController
@RequestMapping("/remark")
public class RemarkController {
    @Autowired
    private RemarkServiceImpl remarkService;

    @PostMapping("/findByRemarkId")
    public ResponseResult<Remark> findByRemarkId(String remarkId){
        String remark = selectByRemarkId(remarkId);
        if(remark == null)
            return ResponseResult.errorResult(404,"未找到该评论");
        else
            return ResponseResult.okResult(200,"查询成功",remark);
    }
    public String selectByRemarkId (String remarkId){
        Remark remark = remarkService.getBaseMapper().selectOne(new QueryWrapper<Remark>().eq("remarkId",remarkId));
        if(remark == null) return null;
        return remark.toString();
    }




}
