package com.github.mimiknight.kuca.simple.myabtis.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.OffsetDateTimeTypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * 自定义{@link OffsetDateTime}时间类型转换器
 * <p>
 * 支持自定义入数据库时间格式及时区
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-10-11 07:55:06
 */
@MappedTypes(value = OffsetDateTime.class)
public class MyOffsetDateTimeType2Handler extends OffsetDateTimeTypeHandler implements ConvertDatabaseTime<OffsetDateTime> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, OffsetDateTime parameter, JdbcType jdbcType) throws SQLException {
        if (null == parameter) {
            ps.setObject(i, null);
            return;
        }
        OffsetDateTime dateTime = parameter.withOffsetSameInstant(ZoneOffset.of(UTC));
        String strDateTime = dateTime.format(DATE_TIME_FORMATTER);
        ps.setString(i, strDateTime);
    }

    @Override
    public OffsetDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        LocalDateTime result = rs.getObject(columnName, LocalDateTime.class);
        return convert(result);
    }

    @Override
    public OffsetDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        LocalDateTime result = rs.getObject(columnIndex, LocalDateTime.class);
        return convert(result);
    }

    @Override
    public OffsetDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        LocalDateTime result = cs.getObject(columnIndex, LocalDateTime.class);
        return convert(result);
    }

    @Override
    public OffsetDateTime convert(LocalDateTime result) {
        if (null == result) {
            return null;
        }
        return OffsetDateTime.of(result, ZoneOffset.of(UTC));
    }

}
