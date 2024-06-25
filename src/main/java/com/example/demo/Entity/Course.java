package com.example.demo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @TableId(value = "courseId",type = IdType.AUTO)
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
    @TableField(value = "bv")
    String bv;
    public Course(Course course) {
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
        this.bv =getBV(course.url);
    }
    public static String getBV(String sourceUrl) {
        String regex = "bvid=([^&]+)";
        Pattern pattern =  Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sourceUrl);
        if (matcher.find()) {
            return matcher.group(1); // group(1) 返回第一个捕获组（即 bvid 的值）
        }
        return null;
    }

}
