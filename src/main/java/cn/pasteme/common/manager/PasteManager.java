package cn.pasteme.common.manager;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.utils.result.Response;

/**
 * PermanentManager 和 TemporaryManager 的上层接口
 *
 * @author Lucien
 * @version 1.1.1
 */
public interface PasteManager {

    /**
     * DTO 转 DO 递交持久化
     *
     * @param pasteRequestDTO 持久 Paste
     * @return 数据库中 record 的主键
     */
    Response<String> save(PasteRequestDTO pasteRequestDTO);

    /**
     * 从数据库中查询 record
     *
     * @param key 主键
     * @return PasteResponseDTO
     */
    Response<PasteResponseDTO> get(String key);

    /**
     * 删除数据库中的 record
     *
     * 如果是 Permanent 则进行软删除
     * @param key 主键
     * @return 删除成功或失败
     */
    Response erase(String key);

    /**
     * 查询数据库中有多少条记录
     *
     * @return 数量
     */
    Response<Long> countAll();
}
