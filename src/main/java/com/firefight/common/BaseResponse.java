package com.firefight.common;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BaseResponse<T> {
    private Boolean success;
    private Integer code;
    private String msg;
    private String rid;
    private T data;

    private BaseResponse() {
        this.rid = generateRequestId();
    }

    // 生成请求ID
    private static String generateRequestId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    // 成功响应的构造方法
    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setCode(ErrorCode.Success.getCode());
        response.setMsg(ErrorCode.Success.getMsg());
        response.setData(data);
        return response;
    }

    // 成功响应但无数据的构造方法
    public static <T> BaseResponse<T> success() {
        return success(null);
    }

    // 错误响应的构造方法
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(false);
        response.setCode(errorCode.getCode());
        response.setMsg(errorCode.getMsg());
        return response;
    }

    // 自定义错误消息的错误响应构造方法
    public static <T> BaseResponse<T> error(ErrorCode errorCode, String customMsg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(false);
        response.setCode(errorCode.getCode());
        response.setMsg(customMsg);
        return response;
    }

    // 完全自定义的错误响应构造方法
    public static <T> BaseResponse<T> error(int code, String msg, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(false);
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    // 判断响应是否成功的便捷方法
    public boolean isSuccess() {
        return Boolean.TRUE.equals(this.success);
    }
}