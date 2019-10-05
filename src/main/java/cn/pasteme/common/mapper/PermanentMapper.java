package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

/**
 * @author Irene, 白振宇
 * @date 2019/9/30 00:58
 */
@Mapper
@Component
public interface PermanentMapper {

    /**
     * 根据 key 得到 DO
     * @param key 主键
     * @return PermanentDO
     */
    @Select("SELECT * FROM `pasteme`.`permanents` WHERE `key` = #{key} AND `deleted_at` IS NULL")
    PermanentDO getByKey(Long key);

    /**
     * 插入 permanentDO 新记录
     * @param permanentDO 永久实体
     * @return key 主键
     */
    @Insert("INSERT INTO `pasteme`.`permanents` (`lang`, `content`, `password`, `client_ip`, `created_at`) " +
            "VALUE (#{lang}, #{content}, #{password}, #{clientIp}, now())")
    @Options(useGeneratedKeys = true, keyProperty = "key", keyColumn = "key")
    Long create(PermanentDO permanentDO);

    /**
     * 根据 key 删除 记录
     * @param key 主键
     * @return 是否删除成功
     */
    @Update("UPDATE `pasteme`.`permanents` SET `deleted_at` = now() WHERE `key`= #{key}")
    Boolean eraseByKey(Long key);
}
