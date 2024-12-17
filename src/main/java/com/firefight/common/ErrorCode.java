package com.firefight.common;

import lombok.Getter;

@Getter
public enum ErrorCode {
    Success(20000, "成功"), AUTH_FAILED(40100, "认证失败"), NO_AUTH(40300, "无权访问"), SYSTEM_ERROR(50000, "系统异常"), PARAM_ERROR(50001, "系统参数错误或数据异常");
    private final int code;
    private final String msg;

    ErrorCode(int code, String message) {
        this.code = code;
        this.msg = message;
    }

}
