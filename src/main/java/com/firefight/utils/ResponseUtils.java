package com.firefight.utils;

import com.firefight.common.BaseResponse;
import com.firefight.common.ErrorCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
public class ResponseUtils<T> implements Serializable {
    /**
     * 构建成功响应（无数据）
     */
    public static <T> BaseResponse<T> success() {
        return buildResponse(true, ErrorCode.Success.getCode(), ErrorCode.Success.getMsg(), null);
    }

    /**
     * 构建成功响应（带数据）
     */
    public static <T> BaseResponse<T> success(T data) {
        return buildResponse(true, ErrorCode.Success.getCode(), ErrorCode.Success.getMsg(), data);
    }

    /**
     * 认证失败响应
     */
    public static <T> BaseResponse<T> authFailed() {
        return buildResponse(false, ErrorCode.AUTH_FAILED.getCode(), ErrorCode.AUTH_FAILED.getMsg(), null);
    }

    /**
     * 认证失败响应（自定义消息）
     */
    public static <T> BaseResponse<T> authFailed(T data) {
        return buildResponse(false, ErrorCode.AUTH_FAILED.getCode(), ErrorCode.AUTH_FAILED.getMsg(), data);
    }

    /**
     * 无权访问响应
     */
    public static <T> BaseResponse<T> noAuth() {
        return buildResponse(false, ErrorCode.NO_AUTH.getCode(), ErrorCode.NO_AUTH.getMsg(), null);
    }

    /**
     * 无权访问响应（自定义消息）
     */
    public static <T> BaseResponse<T> noAuth(T data) {
        return buildResponse(false, ErrorCode.NO_AUTH.getCode(), ErrorCode.NO_AUTH.getMsg(), data);
    }

    /**
     * 系统错误响应
     */
    public static <T> BaseResponse<T> systemError() {
        return buildResponse(false, ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMsg(), null);
    }

    /**
     * 系统错误响应（自定义消息）
     */
    public static <T> BaseResponse<T> systemError(T data) {
        return buildResponse(false, ErrorCode.SYSTEM_ERROR.getCode(), ErrorCode.SYSTEM_ERROR.getMsg(), data);
    }

    /**
     * 参数错误响应
     */
    public static <T> BaseResponse<T> paramError() {
        return buildResponse(false, ErrorCode.PARAM_ERROR.getCode(), ErrorCode.PARAM_ERROR.getMsg(), null);
    }

    /**
     * 参数错误响应（自定义消息）
     */
    public static <T> BaseResponse<T> paramError(T data) {
        return buildResponse(false, ErrorCode.PARAM_ERROR.getCode(), ErrorCode.PARAM_ERROR.getMsg(), data);
    }

    /**
     * 构建自定义错误响应
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return buildResponse(false, errorCode.getCode(), errorCode.getMsg(), null);
    }

    /**
     * 构建自定义错误响应（带自定义消息）
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode, T data) {
        return buildResponse(false, errorCode.getCode(), errorCode.getMsg(), data);
    }

    /**
     * 构建通用响应
     */
    private static <T> BaseResponse<T> buildResponse(boolean success, int code, String msg, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(success);
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        response.setRid(generateRequestId());
        return response;
    }

    /**
     * 生成请求ID
     */
    private static String generateRequestId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 判断响应是否成功
     */
    public static boolean isSuccess(BaseResponse<?> response) {
        return response != null && response.isSuccess() && ErrorCode.Success.getCode() == response.getCode();
    }

    private ResponseUtils() {
        throw new IllegalStateException("Utility class");
    }
}
