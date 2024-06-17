package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.Remark;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.service.RemarkService;
import com.example.demo.service.serviceImpl.RemarkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/findByRemarkId")
    public ResponseResult findByRemarkId(String remarkId){
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

    List<Remark> selectByCourseId(String courseId){
        List<Remark> remarks = remarkService.getBaseMapper().selectList(new QueryWrapper<Remark>().eq("courseId",courseId));
        if(remarks.size() == 0)
            return null;
        return remarks;
    }
    @GetMapping("/findByCourseId")
    public ResponseResult findByCourseId(String courseId){
        List<Remark> remarks = selectByCourseId(courseId);
        if(remarks == null)
            return ResponseResult.errorResult(404,"该课程还没有评论");
        else
            return new ResponseResult(200,"查询成功",remarks);
    }

    @PostMapping("/add")
    public ResponseResult add(Remark remark){
        try{
            remarkService.getBaseMapper().insert(new Remark(remark));
            return ResponseResult.okResult(200,"评论成功");
        }catch(Exception e) {
            System.out.println(e);
            return ResponseResult.errorResult(500, "评论失败");
        }
    }
    @PostMapping("/delete")
    public ResponseResult delete(String remarkId){
        if(selectByRemarkId(remarkId)==null) return ResponseResult.errorResult(404,"未找到该评论");
        try{
            remarkService.getBaseMapper().delete(new QueryWrapper<Remark>().eq("remarkId",remarkId));
            return ResponseResult.okResult(200,"删除成功");
        }catch(Exception e) {
            System.out.println(e);
            return ResponseResult.errorResult(500, "删除失败");
        }
    }



}
