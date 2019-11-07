package cn.pasteme.common.manager.impl;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.entity.TemporaryDO;
import cn.pasteme.common.manager.TemporaryManager;
import cn.pasteme.common.mapper.TemporaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Irene
 * @version 1.0.0
 */

@Service
public class TemporaryManagerImpl implements TemporaryManager {

    private final TemporaryMapper temporaryMapper;

    public TemporaryManagerImpl(TemporaryMapper temporaryMapper) {
        this.temporaryMapper = temporaryMapper;
    }

    @Override
    public String save(PasteRequestDTO pasteRequestDTO) {
        TemporaryDO temporaryDO = new TemporaryDO();
        temporaryDO.setKey(pasteRequestDTO.getKey());
        temporaryDO.setContent(pasteRequestDTO.getContent());
        temporaryDO.setLang(pasteRequestDTO.getLang());
        temporaryDO.setClientIp(pasteRequestDTO.getClientIp());
        temporaryDO.setPassword(pasteRequestDTO.getPassword());
        if (temporaryMapper.create(temporaryDO) == 1){
            return temporaryDO.getKey();
        } else {
            return null;
        }
    }

    @Override
    public PasteResponseDTO get(String key) {
        TemporaryDO temporaryDO = temporaryMapper.getByKey(key);
        if (temporaryDO != null) {
            PasteResponseDTO pasteResponseDTO = new PasteResponseDTO();
            pasteResponseDTO.setContent(temporaryDO.getContent());
            pasteResponseDTO.setLang(temporaryDO.getLang());
            return pasteResponseDTO;
        } else {
            return null;
        }
    }

    @Override
    public Boolean erase(String key) {
        if (temporaryMapper.getByKey(key) == null) {
            return false;
        } else {
            return temporaryMapper.eraseByKey(key) == 1;
        }
    }

    @Override
    public Integer status(String key) {
        if (temporaryMapper.getByKey(key) == null){
            return -1;
        } else {
            return 0;
        }
    }
}
