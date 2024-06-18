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
 * @Author: Zoey
 * @Date: 2024/05/22/10:30
 * @Description:
 */
//@EntityScan
//@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User {
    @TableId(value = "userId",type= IdType.AUTO)
    private String userId;
    @TableField(value = "username")
    private String username;
    @TableField(value = "password")
    private String password;
    @TableField(value = "email")
    private String email;
    @TableField(value = "gender")
    private String gender;
    @TableField(value = "userType")
    private String userType;
    @TableField(value = "follows")
    private Integer follows;
    @TableField(value = "cares")
    private Integer cares;
    public User(User user){
        this.username=user.username;
        this.password=user.password;
        this.email=user.email;
        this.gender=user.gender;
        this.userType=user.userType;
        this.follows=0;
        this.cares=0;
    }
//public String toString(){
//    if(this.userId==null)
//       return null;
//    else return super.toString();
//}
}
