package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * Created by 白振宇 on 2019/9/30 00:58
 */
@Mapper
@Component
public interface PermanentMapper {

    @Select("select * from `pasteme`.`permanents` where `key` = #{key} ")
    PermanentPO getByKeyPermanent(Long key);
}
