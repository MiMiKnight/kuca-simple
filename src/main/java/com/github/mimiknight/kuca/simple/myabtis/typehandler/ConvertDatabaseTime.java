package com.github.mimiknight.kuca.simple.myabtis.typehandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * 转换数据库时间接口
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-10-11 22:31:08
 */
public interface ConvertDatabaseTime<T> {

    /**
     * 默认时区
     */
    TimeZone DEFAULT_TIME_ZONE = TimeZone.getDefault();

    /**
     * UTC 时区
     */
    String UTC = "UTC";
    /**
     * GMT零时区
     */
    String GMT = "GMT";

    /**
     * 日期格式
     */
    String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSSSSSSSS";

    /**
     * 默认日期格式化对象
     */
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

    /**
     * 转换
     *
     * @param localDateTime 本地时间
     * @return {@link T}
     */
    T convert(LocalDateTime localDateTime);
}
