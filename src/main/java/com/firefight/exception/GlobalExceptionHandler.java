package com.firefight.exception;

import com.firefight.common.BaseResponse;
import com.firefight.common.ErrorCode;
import com.firefight.common.ResultUtils;
import com.firefight.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<?> businessExceptionHandler(BusinessException e) {
        log.error("业务异常：" + e.getMessage(), e);
        return ResultUtils.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public BaseResponse runtimeExceptionHandler(RuntimeException e) {
        log.error("runtimeException", e);
        return ResponseUtils.error(ErrorCode.SYSTEM_ERROR, ErrorCode.SYSTEM_ERROR.getMsg());
    }
}