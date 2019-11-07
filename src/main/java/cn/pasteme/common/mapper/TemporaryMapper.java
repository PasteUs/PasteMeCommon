package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.TemporaryDO;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @author Lucien, Irene, 白振宇
 * @version 1.1.0
 */
@Repository
public interface TemporaryMapper {

    /**
     * 根据 key 查询 DO
     * @param key key
     * @return TemporaryDO
     */
    @Select("SELECT * FROM `temporaries` WHERE `key` = #{key}")
    TemporaryDO getByKey(@Valid @NotBlank String key);

    /**
     * 插入 temporaryDO 新记录
     * @param temporaryDO 临时实体
     * @return key 主键
     */
    @Insert("INSERT INTO `temporaries` (`key`, `lang`, `content`, `password`, `client_ip`, `created_at`) " +
            "VALUE (#{key}, #{lang}, #{content}, #{password}, #{clientIp}, now())")
    Long create(@Valid TemporaryDO temporaryDO);

    /**
     * 根据 key 删除 记录
     * @param key 主键
     * @return 是否删除成功
     */
    @Delete("DELETE FROM `temporaries` WHERE `key` = #{key}")
    Long eraseByKey(@Valid @NotBlank String key);

    @Select("SELECT COUNT(1) FROM `temporaries`")
    Long countAll();

    @Select("SELECT COUNT(1) FROM `temporaries` WHERE `key` = #{key}")
    Long countByKey(String key);
}
