package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author 白振宇
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
    @Select("select * from `pasteme`.`permanents` where `key` = #{key} ")
    PermanentDO getByKey(Long key);

    //TODO
    /**
     * 插入 permanentDO 新记录
     * @param permanentDO 永久实体
     * @return key 主键
     */
    Long create(PermanentDO permanentDO);

    //TODO
    /**
     * 根据 key 删除 记录
     * @param key 主键
     * @return 是否删除成功
     */
    Boolean eraseByKey(Long key);
}
