package com.github.mimiknight.kuca.simple.exception;

import com.github.mimiknight.kuca.simple.error.standard.StringErrorReturn;
import lombok.Getter;

/**
 * 自定义业务异常
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-13 23:35:14
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -6162198998783603161L;

    private final StringErrorReturn errorReturn;


    public BusinessException(StringErrorReturn eReturn) {
        super(eReturn.getErrorCode() + "::" + eReturn.getMessage());
        this.errorReturn = eReturn;
    }

    public BusinessException(StringErrorReturn eReturn, Throwable cause) {
        super(eReturn.getErrorCode() + "::" + eReturn.getMessage(), cause);
        this.errorReturn = eReturn;
    }
}
