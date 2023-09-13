package com.github.mimiknight.kuca.simple.aspect;

import com.github.mimiknight.kuca.simple.error.standard.StringErrorReturn;
import com.github.mimiknight.kuca.simple.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理切面
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 09:32:54
 */
@Slf4j
public abstract class BaseGlobalExceptionHandle {

    /**
     * 自定义业务异常
     *
     * @param e 异常类型 {@link BusinessException}
     * @return {@link ResponseEntity}
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<StringErrorReturn> handle(BusinessException e) {
        StringErrorReturn eReturn = e.getErrorReturn();
        return ResponseEntity.status(eReturn.getErrorType().getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(e.getErrorReturn());
    }

}
