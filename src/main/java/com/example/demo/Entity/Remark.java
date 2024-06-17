package com.example.demo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zoey
 * \\_/__/
 * @Date: 2024/06/12/11:50
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "remarks")
public class Remark {
    @TableId(value = "remarkId",type = IdType.AUTO)
    private String remarkId;
    @TableField(value = "courseId")
    private String courseId;
    @TableField(value = "remarkTime")
    private String remarkTime;
    @TableField(value = "userId")
    private String userId;
    @TableField(value = "content")
    private String content;
    @TableField(value = "likes")
    private Integer likes;
    public Remark(Remark remark) {
        this.courseId = remark.courseId;
        this.remarkTime = remark.remarkTime;
        this.userId = remark.userId;
        this.content = remark.content;
        this.likes = 0;
    }
}
