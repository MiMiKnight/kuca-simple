package com.github.mimiknight.kuca.simple.aspect;

import com.github.mimiknight.kuca.simple.error.standard.IErrorReturn;
import com.github.mimiknight.kuca.simple.error.standard.IErrorType;
import com.github.mimiknight.kuca.simple.exception.BusinessException;
import com.github.mimiknight.kuca.simple.exception.ParamValidException;
import com.github.mimiknight.kuca.simple.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理切面基类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 09:32:54
 */
@Slf4j
public abstract class BaseGlobalExceptionHandle {

    /**
     * 处理 自定义业务异常
     *
     * @param e 异常类型 {@link BusinessException}
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionResponse> handle(BusinessException e) {
        return buildEntity(e.getErrorReturn());
    }


    /**
     * 处理 自定义（手动）校验参数异常
     *
     * @param e 异常类型 {@link BusinessException}
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(value = ParamValidException.class)
    public ResponseEntity<ExceptionResponse> handle(ParamValidException e) {
        return buildEntity(e.getErrorReturn());
    }

    /**
     * 构建异常响应
     *
     * @param eReturn 错误返回对象
     * @return {@link ResponseEntity}
     */

    protected ResponseEntity<ExceptionResponse> buildEntity(IErrorReturn<?> eReturn) {
        int statusCode = eReturn.getErrorType().getStatusCode();
        ExceptionResponse body = buildBody(eReturn);
        return ResponseEntity.status(statusCode).contentType(MediaType.APPLICATION_JSON).body(body);
    }

    /**
     * 构建异常响应体
     *
     * @param eReturn 错误返回对象
     * @return {@link ExceptionResponse}
     */
    protected ExceptionResponse buildBody(IErrorReturn<?> eReturn) {
        String errorCode = eReturn.getErrorCode();
        IErrorType errorType = eReturn.getErrorType();
        int statusCode = errorType.getStatusCode();
        String errorTypeName = errorType.getName();
        return ExceptionResponse.builder()
                .statusCode(statusCode)
                .errorCode(errorCode)
                .errorType(errorTypeName)
                .data(eReturn.getMessage())
                .build();
    }

}
