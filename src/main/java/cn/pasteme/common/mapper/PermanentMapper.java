package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Irene, 白振宇
 * @date 2019/09/30 00:58
 */
@Mapper
@Component
public interface PermanentMapper {

    /**
     * 根据 key 得到 DO
     * @param key 主键
     * @return PermanentDO
     */
    @Select("SELECT * FROM `permanents` WHERE `key` = #{key} AND `deleted_at` IS NULL")
    PermanentDO getByKey(@Valid @NotNull Long key);

    /**
     * 插入 permanentDO 新记录
     * @param permanentDO 永久实体
     * @return key 主键
     */
    @Insert("INSERT INTO `permanents` (`lang`, `content`, `password`, `client_ip`, `created_at`) " +
            "VALUE (#{lang}, #{content}, #{password}, #{clientIp}, now())")
    @Options(useGeneratedKeys = true, keyProperty = "key", keyColumn = "key")
    Long create(@Valid PermanentDO permanentDO);

    /**
     * 根据 key 删除 记录
     * @param key 主键
     * @return 是否删除成功
     */
    @Update("UPDATE `permanents` SET `deleted_at` = now() WHERE `key`= #{key}")
    Long eraseByKey(@Valid @NotNull Long key);
}
