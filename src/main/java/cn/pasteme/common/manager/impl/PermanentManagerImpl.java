package cn.pasteme.common.manager.impl;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.manager.PermanentManager;

/**
 * @author Irene
 * @version 1.0.0
 */
public class PermanentManagerImpl implements PermanentManager {
    @Override
    public String save(PasteRequestDTO pasteRequestDTO) {
        return pasteRequestDTO.getKey();
    }

    @Override
    public PasteResponseDTO get(String key) {
//        PermanentManager
        return null;
    }

    @Override
    public Boolean erase(String key) {
        return null;
    }

    @Override
    public Integer status(String key) {
        return null;
    }
}
