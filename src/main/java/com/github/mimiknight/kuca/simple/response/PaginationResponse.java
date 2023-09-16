package com.github.mimiknight.kuca.simple.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.response.EcologyResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * 分页响应抽象类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-20 16:23:13
 */
@Getter
@Setter
public abstract class PaginationResponse<T> implements EcologyResponse {

    /**
     * 总记录数
     */
    @JsonProperty(value = "total", index = 1)
    private Long total;

    /**
     * 结果集
     */
    @JsonProperty(value = "results", index = 2)
    private List<T> results = Collections.emptyList();

}