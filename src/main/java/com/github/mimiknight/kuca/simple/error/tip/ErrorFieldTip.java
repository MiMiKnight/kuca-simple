package com.github.mimiknight.kuca.simple.error.tip;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 字段校验错误提示类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-13 23:40:30
 */
@Setter
@Getter
public class ErrorFieldTip extends ErrorTip {

    @JsonProperty(value = "field")
    private String field;


    public ErrorFieldTip(String field, String tip) {
        super(tip);
        this.field = field;
    }

    /**
     * 构建ErrorFieldTip
     *
     * @param field 字段名称
     * @param tip   提示信息
     * @return {@link ErrorFieldTip}
     */
    public static ErrorFieldTip build(String field, String tip) {
        return new ErrorFieldTip(field, tip);
    }
}
