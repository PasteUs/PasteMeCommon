package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.Temporary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author: 白振宇
 * @Date： 2019/9/30 0:58
 */
@Mapper
@Component
public interface TemporariesMapper {

    @Select("select * from `pasteme`.`temporaries` where `key` = #{key}")
    Temporary getByKeyTemporary(String key);
}
