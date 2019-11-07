package cn.pasteme.common.manager.impl;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.entity.PermanentDO;
import cn.pasteme.common.manager.PermanentManager;
import cn.pasteme.common.mapper.PermanentMapper;
import org.springframework.stereotype.Service;

/**
 * @author Lucien, Irene
 * @version 1.1.0
 */
@Service
public class PermanentManagerImpl implements PermanentManager {

    private final PermanentMapper permanentMapper;

    public PermanentManagerImpl(PermanentMapper permanentMapper) {
        this.permanentMapper = permanentMapper;
    }

    @Override
    public String save(PasteRequestDTO pasteRequestDTO) {
        PermanentDO permanentDO = new PermanentDO();
        permanentDO.setKey(Long.valueOf(pasteRequestDTO.getKey()));
        permanentDO.setLang(pasteRequestDTO.getLang());
        permanentDO.setContent(pasteRequestDTO.getContent());
        permanentDO.setPassword(pasteRequestDTO.getPassword());
        permanentDO.setClientIp(pasteRequestDTO.getClientIp());
        if (permanentMapper.create(permanentDO) == 1){
            return String.valueOf(permanentDO.getKey());
        } else {
            return null;
        }

    }

    @Override
    public PasteResponseDTO get(String key) {
        PermanentDO permanentDO = permanentMapper.getByKey(Long.valueOf(key));
        if (permanentDO != null) {
            if (permanentDO.getDeletedAt() != null) {
                PasteResponseDTO pasteResponseDTO = new PasteResponseDTO();
                pasteResponseDTO.setLang(permanentDO.getLang());
                pasteResponseDTO.setContent(permanentDO.getContent());
                return pasteResponseDTO;
            }
        }
        return null;
    }

    @Override
    public Boolean erase(String key) {
        if (permanentMapper.getByKey(Long.valueOf(key)) == null){
            return false;
        } else {
            return permanentMapper.eraseByKey(Long.valueOf(key)) == 1;
        }
    }

    @Override
    public Integer status(String key) {
        if (permanentMapper.getByKey(Long.valueOf(key)) == null) {
            return 0;
        } else {
            if (permanentMapper.getByKey(Long.valueOf(key)).getDeletedAt() != null) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public Long count() {
        return null;
    }

    @Override
    public Long getCurrentMaxKey() {
        return null;
    }
}
