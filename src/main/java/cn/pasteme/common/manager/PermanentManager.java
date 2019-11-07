package cn.pasteme.common.manager;

/**
 * @author Lucien
 * @version 1.0.0
 */
public interface PermanentManager extends PasteManager {

    /**
     * 获取最大的 key
     *
     * @return 最大的 key
     */
    Long getCurrentMaxKey();
}
