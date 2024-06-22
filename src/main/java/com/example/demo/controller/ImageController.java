package com.example.demo.controller;

import com.example.demo.Entity.Image;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.ResponseResult;
import com.example.demo.service.serviceImpl.ImageServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zoey
 * \\_/__/
 * @Date: 2024/06/19/23:59
 * @Description:
 */
@RestController
@Api(tags = "Image")
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageServiceImpl imageService;
    @GetMapping("/selectById")
    public ResponseResult selectById(@RequestParam String Id){
        try{
            Image image=imageService.getBaseMapper().selectById(Id);
            return image!=null?(new ResponseResult(200,"查找成功",image.getPictures())):ResponseResult.errorResult(500,"图片不存在");
        }catch(Exception e){
            System.out.println(e);
            return ResponseResult.errorResult(500,e.toString());
        }
    }
    @PostMapping("/upload")
    public ResponseResult addPost(@RequestParam("file") MultipartFile file) {
        try {
            imageService.getBaseMapper().insert(new Image(file));
            return ResponseResult.okResult(200,"新增成功");
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseResult<>().error(500,e.toString());
        }

    }
}
