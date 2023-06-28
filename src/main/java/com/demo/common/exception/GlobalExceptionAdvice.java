package com.demo.common.exception;

import com.demo.common.Result.AjaxResult;
import com.demo.common.constants.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResult methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return AjaxResult.error(HttpStatus.BAD_REQUEST,"参数异常："+e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(LoginException.class)
    public AjaxResult loginException(LoginException e) {
        return AjaxResult.error(HttpStatus.FORBIDDEN,"登录异常："+e.getMessage());
    }
    @ExceptionHandler(ServiceException.class)
    public AjaxResult serviceException(ServiceException e) {
        return AjaxResult.error(HttpStatus.ERROR,"系统异常："+e.getMessage());
    }
}
