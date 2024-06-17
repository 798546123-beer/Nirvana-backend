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
@TableName(value="userphysicaldata")
public class UserPhysicalData {
    @TableId(value = "userId")
    String userId;
    @TableField(value = "height")
    float height;
    @TableField(value = "weight")
    float weight;
    @TableField(value = "age")
    int age;
}
