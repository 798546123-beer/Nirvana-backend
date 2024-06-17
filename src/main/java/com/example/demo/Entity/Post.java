package com.example.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/15
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "post")
public class Post {
    @TableId(value = "postId")
    String postId;
    @TableField(value = "authorId")
    String autherId;
    @TableField(value = "content")
    String content;
    @TableField(value = "publishDate")
    String publishDate;
    @TableField(value="status")
    String status;
    @TableField(value="likes")
    Integer likes;
    @TableField(value="courseId")
    String courseId;
    public Post(Post post) {
//        this.postId = post.postId;
        this.autherId = post.autherId;
        this.content = post.content;
        this.publishDate = post.publishDate;
        this.status ="Pending";
        this.likes = 0;
        this.courseId = post.courseId;
    }
}
