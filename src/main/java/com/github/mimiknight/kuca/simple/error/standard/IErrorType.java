package com.github.mimiknight.kuca.simple.error.standard;

/**
 * 错误类型接口
 * <p>
 * 实现类适用于枚举类型
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-13 23:26:27
 */
public interface IErrorType {

    /**
     * 获取错误类型名称
     *
     * @return {@link String}
     */
    String getName();

    /**
     * 获取HTTP状态码
     *
     * @return int
     */
    int getStatusCode();
}
