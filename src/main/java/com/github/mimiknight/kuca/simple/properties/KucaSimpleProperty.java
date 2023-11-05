package com.github.mimiknight.kuca.simple.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "kuca.simple")
public class KucaSimpleProperty {

    /**
     * 数据库默认时区
     * <p>
     * 设置该参数后自动将java时间转换为指定时区后存入数据库
     */
    private String databaseTimeZone = "UTC";
}
