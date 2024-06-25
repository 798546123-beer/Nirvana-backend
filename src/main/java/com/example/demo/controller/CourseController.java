package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.Course;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.service.serviceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/15
 * @Description:
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;
    @PostMapping("/upload")
    public ResponseResult add(@RequestBody Course course){
        try{
            courseService.getBaseMapper().insert(new Course(course));
            return ResponseResult.okResult(200,"上传成功");
        }catch (Exception e){
            System.out.println(e);
            return ResponseResult.errorResult(500,"上传失败");
        }

    }

    public String selectByCourseId(String courseId){
        Course course = courseService.getBaseMapper().selectOne(new QueryWrapper<Course>().eq("courseId",courseId));
        if(course==null) return null;
        return course.toString();
    }
    @GetMapping("/findByCourseId")
    public ResponseResult findByCourseId(String courseId){
        String selectByCourseId = selectByCourseId(courseId);
        if(selectByCourseId==null){
            return ResponseResult.errorResult(500,"课程不存在");
        }
        return ResponseResult.okResult(200,"查询成功",selectByCourseId);
    }


    @PostMapping("/delete")
    public ResponseResult delete(@RequestParam String courseId){
        if(selectByCourseId(courseId)==null){
            return ResponseResult.errorResult(500,"课程不存在");
        }
        try{
            courseService.getBaseMapper().delete(new QueryWrapper<Course>().eq("courseId",courseId));
            return ResponseResult.okResult(200,"删除成功");
        }catch (Exception e){
            return ResponseResult.errorResult(500,"删除失败");
        }
    }
    public List<Course> selectAll(){
        try{
            List<Course> courses = courseService.getBaseMapper().selectList(null);
            return courses;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/selectAll")
    public ResponseResult findAll(){

            List<Course> courses = selectAll();
            if(courses!=null){
                return new ResponseResult(200,"查询成功",courses);
            }else{
                return new ResponseResult(500,"课程未找到");
            }
    }
//按标签查询
    public List<Course> selectByTag(String tag){
        try{
            List<Course> courses = courseService.getBaseMapper().selectList(new QueryWrapper<Course>().like("tags",tag));
            return courses;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/selectByTags")
    public ResponseResult findByTag(String tag){
        List<Course> courses = selectByTag(tag);
        if(courses!=null){
            return new ResponseResult(200,"查询成功",courses);
        }else{
            return new ResponseResult(500,"课程未找到");
        }
    }

//按课程名查询
    public List<Course> selectByTitle(String title){
        try{
            List<Course> courses = courseService.getBaseMapper().selectList(new QueryWrapper<Course>().like("title",title));
            return courses;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    @GetMapping("/selectByTitle")
    public ResponseResult findByTitle(String title){
        List<Course> courses = selectByTitle(title);
        if(courses!=null){
            return new ResponseResult(200,"查询成功",courses);
        }else{
            return new ResponseResult(500,"课程未找到");
        }
    }
}
