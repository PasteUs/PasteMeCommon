package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author 白振宇
 * @date 2019/9/30 00:58
 */
public interface PermanentMapper {

    /**
     * 根据 key 得到 DO
     * @param key 主键
     * @return PermanentDO
     */
    @Select("select * from `pasteme`.`permanents` where `key` = #{key} ")
    PermanentDO getByKeyPermanent(Long key);
}
