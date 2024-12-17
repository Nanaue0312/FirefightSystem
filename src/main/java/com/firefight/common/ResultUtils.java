package com.firefight.common;

/**
 * 响应结果工具类
 */
public class ResultUtils {

    /**
     * 返回成功响应
     */
    public static <T> BaseResponse<T> success() {
        return BaseResponse.success();
    }

    /**
     * 返回带数据的成功响应
     *
     * @param data 响应数据
     */
    public static <T> BaseResponse<T> success(T data) {
        return BaseResponse.success(data);
    }

    /**
     * 返回错误响应
     *
     * @param errorCode 错误码
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return BaseResponse.error(errorCode);
    }

    /**
     * 返回带自定义消息的错误响应
     *
     * @param errorCode 错误码
     * @param msg       自定义错误消息
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode, String msg) {
        return BaseResponse.error(errorCode, msg);
    }

    /**
     * 返回带自定义错误码和消息的错误响应
     *
     * @param code 自定义错误码
     * @param msg  自定义错误消息
     */
    public static <T> BaseResponse<T> error(int code, String msg) {
        // 通过BaseResponse的error方法创建
        return BaseResponse.error(code, msg, null);
    }

    /**
     * 返回带自定义错误码、消息和数据的错误响应
     *
     * @param code 自定义错误码
     * @param msg  自定义错误消息
     * @param data 响应数据
     */
    public static <T> BaseResponse<T> error(int code, String msg, T data) {
        return BaseResponse.error(code, msg, data);
    }

    /**
     * 系统异常响应
     *
     * @param msg 错误消息
     */
    public static <T> BaseResponse<T> systemError(String msg) {
        return BaseResponse.error(ErrorCode.SYSTEM_ERROR, msg);
    }

    /**
     * 参数错误响应
     *
     * @param msg 错误消息
     */
    public static <T> BaseResponse<T> paramError(String msg) {
        return BaseResponse.error(ErrorCode.PARAM_ERROR, msg);
    }
}