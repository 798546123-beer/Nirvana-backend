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
 * @Date: 2024/6/17
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value="usersportdata")
public class UserSportData {
    @TableId(value = "userId")
    String userId;
    @TableField(value = "sportType")
    String sportType;
    @TableField(value = "time")
    String time;
    @TableField(value = "times")
    int times;
}
