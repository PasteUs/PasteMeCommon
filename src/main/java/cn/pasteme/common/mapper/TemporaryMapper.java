package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.TemporaryDO;
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

    /**
     * 根据 key 查询 DO
     * @param key key
     * @return TemporaryDO
     */
    @Select("select * from `pasteme`.`temporaries` where `key` = #{key}")
    TemporaryDO getByKey(String key);

    //TODO
    /**
     * 插入 temporaryDO 新记录
     * @param temporaryDO 临时实体
     * @return key 主键
     */
    String create(TemporaryDO temporaryDO);

    //TODO
    /**
     * 根据 key 删除 记录
     * @param key 主键
     * @return 是否删除成功
     */
    Boolean eraseByKey(String key);
}
