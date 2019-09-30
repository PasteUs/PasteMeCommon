package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.Permanent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author: 白振宇
 * @Date： 2019/9/30 0:58
 */
@Mapper
@Component
public interface PermanentsMapper {

    @Select("select * from `pasteme`.`permanents` where `key` = #{key} ")
    Permanent getByKeyPermanent(Long key);


}
