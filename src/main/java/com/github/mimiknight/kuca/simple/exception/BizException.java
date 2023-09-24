package com.github.mimiknight.kuca.simple.exception;

import com.github.mimiknight.kuca.simple.error.standard.ErrorTipErrorReturn;
import lombok.Getter;

/**
 * 自定义业务异常
 * <p>
 * Business 缩写 biz
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-13 23:35:14
 */
@Getter
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -6162198998783603161L;

    private final transient ErrorTipErrorReturn errorReturn;


    public BizException(ErrorTipErrorReturn eReturn) {
        super(eReturn.getErrorCode() + "::" + eReturn.getMessage().getTip());
        this.errorReturn = eReturn;
    }

    public BizException(ErrorTipErrorReturn eReturn, Throwable cause) {
        super(eReturn.getErrorCode() + "::" + eReturn.getMessage().getTip(), cause);
        this.errorReturn = eReturn;
    }
}
