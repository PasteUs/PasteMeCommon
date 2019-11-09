package cn.pasteme.common.mapper.handler;

import cn.pasteme.common.enumeration.ValueEnum;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import javax.validation.constraints.NotNull;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Lucien
 * @version 1.0.0
 */
public class ValueEnumTypeHandler<E extends Enum<?> & ValueEnum> extends BaseTypeHandler<ValueEnum> {

    private Class<E> type;

    private static <E extends Enum<?> & ValueEnum> E getEnumByClassValue(Class<E> enumClass, int value) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.getValue() == value)
                return e;
        }
        return null;
    }

    public ValueEnumTypeHandler(@NotNull(message = "Param type can not be null") Class<E> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int columnIndex, ValueEnum parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(columnIndex, parameter.getValue());
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        int value = resultSet.getInt(columnName);
        return resultSet.wasNull() ? null : valueOf(value);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int value = resultSet.getInt(columnIndex);
        return resultSet.wasNull() ? null : valueOf(value);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int value = callableStatement.getInt(columnIndex);
        return callableStatement.wasNull() ? null : valueOf(value);
    }

    private E valueOf(int value) {
        try {
            return getEnumByClassValue(type, value);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format("Cannot convert value: %d to %s by value.", value, type.getSimpleName()), e);
        }
    }
}