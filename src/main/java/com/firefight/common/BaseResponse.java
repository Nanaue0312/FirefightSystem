package com.firefight.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 调用是否成功
     * true - 表示成功
     * false - 表示失败
     */
    private boolean success;

    /**
     * 返回码
     * 20000表示成功，其他皆为失败
     */
    private int code;

    /**
     * 接口执行情况说明信息
     * 正常为"ok"，其他为错误原因
     */
    private String msg;

    /**
     * 请求ID，每次接口唯一
     */
    private String rid;

    /**
     * 响应数据
     */
    private T data;
}
