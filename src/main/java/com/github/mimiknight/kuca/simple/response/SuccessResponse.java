package com.github.mimiknight.kuca.simple.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 成功响应类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-14 00:13:25
 */
@Builder
@Setter
@Getter
public class SuccessResponse {

    /**
     * HTTP状态码
     */
    @JsonProperty(value = "status_code", index = 1)
    private int statusCode;

    /**
     * 数据
     */
    @JsonProperty(value = "data", index = 2)
    private Object data;
}
