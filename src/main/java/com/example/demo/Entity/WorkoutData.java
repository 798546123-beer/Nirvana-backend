package com.example.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: annal
 * \\_/__/
 * @Date: 2024/6/17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="workoutdata")
public class WorkoutData {
    @TableId(value = "workoutId")
    String workoutId;
    @TableField(value = "userId")
    String userId;
    @TableField(value = "duration")
    int duration;
    @TableField(value = "date")
    String date;
    @TableField(value = "workoutType")
    String workoutType;
    public WorkoutData(WorkoutData workoutData) {
        this.workoutId = workoutData.workoutId;
        this.userId = workoutData.userId;
        this.duration = workoutData.duration;
        this.date = workoutData.date;
        this.workoutType = workoutData.workoutType;
    }
}
