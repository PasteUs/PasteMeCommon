package cn.pasteme.common.manager;

import cn.pasteme.common.utils.result.Response;

/**
 * @author Lucien
 * @version 1.1.0
 */
public interface PermanentManager extends PasteManager {

    /**
     * 获取最大的 key
     *
     * @return 最大的 key
     */
    Response<Long> getCurrentMaximumKey();
}
