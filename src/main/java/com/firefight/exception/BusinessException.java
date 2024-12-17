package com.firefight.exception;

import com.firefight.common.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final int code;
    private final String message;

    public BusinessException(String msg, int code, String message) {
        super(msg);
        this.code = code;
        this.message = message;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.message = message;
    }

}