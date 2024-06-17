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
@TableName(value="course")
public class Course {
    @TableId(value = "courseId")
    String courseId;
    @TableField(value = "title")
    String title;
    @TableField(value = "description")
    String description;
    @TableField(value = "coachId")
    String coachId;
    @TableField(value = "difficultyLevel")
    String difficultyLevel;
    @TableField(value = "duration")
    String duration;
    @TableField(value = "category")
    String category;
    @TableField(value = "tags")
    String tags;
    @TableField(value = "rating")
    String rating;
    @TableField(value = "previewAvailable")
    String previewAvailable;
}
