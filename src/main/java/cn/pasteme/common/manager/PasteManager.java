package cn.pasteme.common.manager;

import cn.pasteme.common.dto.PasteContentDTO;

/**
 * @Author: 白振宇
 * @Date： 2019/10/2 1:00
 */
public interface PasteManager<T> {

    PasteContentDTO getPasteContentByKey(T key, String pwd);
}
