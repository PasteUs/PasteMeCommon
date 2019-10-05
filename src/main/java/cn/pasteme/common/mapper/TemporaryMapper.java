package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.TemporaryDO;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author Irene, 白振宇
 * @date 2019/9/30 00:58
 */
@Mapper
@Component
public interface TemporaryMapper {

    /**
     * 根据 key 查询 DO
     * @param key key
     * @return TemporaryDO
     */
    @Select("SELECT * FROM `pasteme`.`temporaries` WHERE `key` = #{key}")
    TemporaryDO getByKey(String key);

    /**
     * 插入 temporaryDO 新记录
     * @param temporaryDO 临时实体
     * @return key 主键
     */
    @Insert("INSERT INTO `pasteme`.`temporaries` (`key`, `lang`, `content`, `password`, `client_ip`, `created_at`) " +
            "VALUE (#{key}, #{lang}, #{content}, #{password}, #{clientIp}, now())")
    String create(TemporaryDO temporaryDO);

    /**
     * 根据 key 删除 记录
     * @param key 主键
     * @return 是否删除成功
     */
    @Delete("DELETE FROM `pasteme`.`temporaries` WHERE `key` = #{key}")
    Boolean eraseByKey(String key);
}
