package cn.pasteme.common.mapper.handler;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Mybatis JSON 到 Object 双向映射
 * @author Lucien
 * @version 1.0.0
 */
@Slf4j
public class JsonTypeHandler<T> extends BaseTypeHandler<T> {

    private Class<T> type;

    public JsonTypeHandler(Class<T> type) {
        if(log.isTraceEnabled()) {
            log.trace("JsonTypeHandler(" + type + ")");
        }
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
    }

    private T parse(String json) {
        try {
            if(json == null || json.length() == 0) {
                return null;
            }
            return JSON.parseObject(json, this.type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String toJsonString(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parse(rs.getString(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parse(rs.getString(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parse(cs.getString(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps,
                                    int columnIndex, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(columnIndex, toJsonString(parameter));
    }
}
