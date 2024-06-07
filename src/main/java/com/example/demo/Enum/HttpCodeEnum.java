package com.example.demo.Enum;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zoey
 * \\_/__/
 * @Date: 2024/06/06/9:29
 * @Description:
 */
public enum HttpCodeEnum {
        SUCCESS(200, "操作成功"),
        NEED_LOGIN(401, "需要登录后操作"),
        NO_OPERATOR_AUTH(403, "无权限操作"),
        SYSTEM_ERROR(500, "出现错误"),
        USERNAME_EXIST(501, "用户名已存在"),
        PHONENUMBER_EXIST(502, "手机号已存在"), EMAIL_EXIST(503, "邮箱已存在"),
        REQUIRE_USERNAME(504, "必需填写用户名"),
        LOGIN_ERROR(505, "用户名或密码错误"),
        USER_NOT_EXIST(506, "用户不存在"),
        TOKEN_OVERTIME(507, "登录超时，请重新登录"),
        INFO_SYSTEM_ERROR(500, "创建userinfo出现错误"),
        USER_DISABLED(508, "该账户被禁用");

        int code;
        String msg;

        HttpCodeEnum(int code, String errorMessage) {
            this.code = code;
            this.msg = errorMessage;
        }

        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }
