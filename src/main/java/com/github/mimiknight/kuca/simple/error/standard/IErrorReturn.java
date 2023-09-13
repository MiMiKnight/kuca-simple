package com.github.mimiknight.kuca.simple.error.standard;

/**
 * 错误返回接口
 * <p>
 * 实现类适用于枚举类型
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-13 23:26:12
 */
public interface IErrorReturn<T> {

    /**
     * 获取错误码
     *
     * @return {@link String}
     */
    String getErrorCode();

    /**
     * 获取错误类型
     *
     * @return {@link IErrorType}
     */
    IErrorType getErrorType();

    /**
     * 获取提示错误提示信息
     *
     * @return {@link T}
     */
    T getMessage();

}
