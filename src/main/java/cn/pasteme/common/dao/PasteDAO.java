package cn.pasteme.common.dao;

import cn.pasteme.common.entity.PastePO;

/**
 * @author Lucien
 * @date 2019/10/01 02:02
 *
 * PermanentDAO 和 TemporaryDAO 的上层接口
 */
public interface PasteDAO {

    /**
     * 将 PastePO 保存至数据库
     * @param pastePO 持久 Paste
     * @return 数据库中 record 的主键
     */
    String save(PastePO pastePO);

    /**
     * 从数据库中查询 record
     * @param id 主键
     * @return PastePO
     */
    PastePO get(String id);

    /**
     * 删除数据库中的 record
     * 如果是 Permanent 则进行软删除
     * @param id 主键
     * @return 删除成功或失败
     */
    Boolean erase(String id);

    /**
     * 查询数据库中 id 的状态
     * @param id 主键
     * @return 0: 不存在, 1: 存在, -1: 存在但被删除
     */
    Integer status(String id);
}
