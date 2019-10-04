package cn.pasteme.common.manager;

import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.entity.PasteDO;

/**
 * @author Lucien
 * @date 2019/10/01 02:02
 *
 * PermanentManager 和 TemporaryManager 的上层接口
 */
public interface PasteManager {

    /**
     * 将 PastePO 保存至数据库
     * @param pasteDO 持久 Paste
     * @return 数据库中 record 的主键
     */
    String save(PasteDO pasteDO);

    /**
     * 从数据库中查询 record
     * @param key 主键
     * @return PasteResponseDTO
     */
    PasteResponseDTO get(String key);

    /**
     * 删除数据库中的 record
     * 如果是 Permanent 则进行软删除
     * @param key 主键
     * @return 删除成功或失败
     */
    Boolean erase(String key);

    /**
     * 查询数据库中 key 的状态
     * @param key 主键
     * @return 0: 不存在, 1: 存在, -1: 存在但被删除
     */
    Integer status(String key);
}
