package com.github.mimiknight.kuca.simple.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 异常响应类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-14 00:13:25
 */
@Builder
@Setter
@Getter
public class ExceptionResponse {

    /**
     * HTTP状态码
     */
    @JsonProperty(value = "status_code", index = 1)
    private int statusCode;

    /**
     * 错误码
     */
    @JsonProperty(value = "error_code", index = 2)
    private String errorCode;

    /**
     * 错误类型
     */
    @JsonProperty(value = "error_type", index = 3)
    private String errorType;

    /**
     * 数据
     */
    @JsonProperty(value = "data", index = 4)
    private Object data;
}
