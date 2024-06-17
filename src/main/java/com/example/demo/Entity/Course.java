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
    int coachId;
    @TableField(value = "difficultyLevel")
    String difficultyLevel;
    @TableField(value = "duration")
    int duration;
    @TableField(value = "category")
    String category;
    @TableField(value = "tags")
    String tags;
    @TableField(value = "rating")
    float rating;
    @TableField(value = "previewAvailable")
    int previewAvailable;
    @TableField(value = "url")
    String url;
    public Course(Course course) {
        this.courseId = course.courseId;
        this.title = course.title;
        this.description = course.description;
        this.coachId = course.coachId;
        this.difficultyLevel = course.difficultyLevel;
        this.duration = course.duration;
        this.category = course.category;
        this.tags = course.tags;
        this.rating = course.rating;
        this.previewAvailable = course.previewAvailable;
        this.url = course.url;
    }
}
