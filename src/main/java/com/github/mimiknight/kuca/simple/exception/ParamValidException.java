package com.github.mimiknight.kuca.simple.exception;

import com.github.mimiknight.kuca.simple.error.standard.ErrorTipErrorReturn;
import lombok.Getter;

/**
 * 自定义参数校验异常
 * <p>
 * 手动校验参数异常
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-13 23:35:14
 */
@Getter
public class ParamValidException extends RuntimeException {

    private static final long serialVersionUID = 7510949842232669220L;
    private final transient ErrorTipErrorReturn errorReturn;


    public ParamValidException(ErrorTipErrorReturn eReturn) {
        super(eReturn.getErrorCode() + "::" + eReturn.getMessage().getTip());
        this.errorReturn = eReturn;
    }

    public ParamValidException(ErrorTipErrorReturn eReturn, Throwable cause) {
        super(eReturn.getErrorCode() + "::" + eReturn.getMessage().getTip(), cause);
        this.errorReturn = eReturn;
    }
}
