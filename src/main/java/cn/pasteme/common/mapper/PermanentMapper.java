package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author Lucien, Irene, 白振宇
 * @version 1.2.2
 */
@Repository
public interface PermanentMapper {

    /**
     * 根据 key 得到 DO
     * @param key 主键
     * @return PermanentDO
     */
    PermanentDO getByKey(@Valid @NotNull Long key);


    /**
     * 插入 permanentDO 新记录
     * @param permanentDO 永久实体
     * @return key 主键
     */
    Long create(@Valid PermanentDO permanentDO);

    /**
     * 根据 key 删除 记录
     * @param key 主键
     * @return 是否删除成功
     */
    @Update("UPDATE `pasteme_permanent` SET `deleted_at` = now() WHERE `key`= #{key}")
    Long eraseByKey(@Valid @NotNull Long key);

    /**
     * permanent 表记录数
     * @return 数量
     */
    @Select("SELECT COUNT(1) FROM `pasteme_permanent`")
    Long countAll();

    /**
     * 该 key 对应的记录数(0 or 1)
     * @param key 主键
     * @return 数量
     */
    @Select("SELECT COUNT(1) FROM `pasteme_permanent` WHERE `key` = #{key}")
    Long countByKey(Long key);

    /**
     * 获取当前最大 key 值
     * @return 主键值
     */
    @Select("SELECT MAX(`key`) FROM `pasteme_permanent`")
    Long getMaxKey();
}
