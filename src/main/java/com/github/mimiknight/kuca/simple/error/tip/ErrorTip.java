package com.github.mimiknight.kuca.simple.error.tip;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.simple.error.standard.IErrorTip;
import lombok.Getter;
import lombok.Setter;

/**
 * 错误提示类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-13 23:40:30
 */
@Setter
@Getter
public class ErrorTip implements IErrorTip {

    @JsonProperty(value = "tip")
    private String tip;

    /**
     * 有参构造
     *
     * @param tip 提示
     */
    public ErrorTip(String tip) {
        this.tip = tip;
    }

    /**
     * 构建ErrorTip
     *
     * @param tip 提示信息
     * @return {@link ErrorTip}
     */
    public static ErrorTip build(String tip) {
        return new ErrorTip(tip);
    }

}
