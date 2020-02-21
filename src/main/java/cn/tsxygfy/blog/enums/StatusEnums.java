package cn.tsxygfy.blog.enums;

import lombok.Getter;
import lombok.Setter;

public enum  StatusEnums {

    METHOD_NOT_ALLOWED(405, "METHOD_NOT_ALLOWED"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    SUCCESS(200, "SUCCESS"),
    ACCOUNT_UNKNOWN(500, "ACCOUNT_UNKNOWN"),
    ACCOUNT_ERROR(401,"用户名或密码错误"),
    SYSTEM_ERROR(500, "系统错误"),
    PARAM_ERROR(400, "参数错误"),
    PARAM_REPEAT(400, "参数已存在"),
    NO_LOGIN(500, "未登录"),
    OTHER(-100, "其他错误");

    @Getter
    @Setter
    private int code;
    @Getter
    @Setter
    private String info;

    StatusEnums(int code, String info) {
        this.code = code;
        this.info = info;
    }

}
