package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author Irene
 * @date 2019/10/05 21:44
 */
@Mapper
@Component
public interface PermanentTestMapper {

    @Insert("INSERT INTO `pasteme`.`permanents` (`key`, `content`, `lang`, `password`, `created_at`) " +
            "VALUE (#{key}, #{content}, #{lang}, #{password}, now())")
    Long create(PermanentDO permanentDO);

    @Delete("DELETE FROM `pasteme`.`permanents` WHERE `key` = #{key}")
    Long delete(Long key);
}
