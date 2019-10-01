package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.TemporaryPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author 白振宇
 * @date 2019/9/30 00:58
 */
@Mapper
@Component
public interface TemporaryMapper {

    @Select("select * from `pasteme`.`temporaries` where `key` = #{key}")
    TemporaryPO getByKeyTemporary(String key);
}
