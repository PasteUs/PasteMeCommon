package cn.pasteme.common.manager.impl;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.entity.PermanentDO;
import cn.pasteme.common.manager.PermanentManager;
import cn.pasteme.common.mapper.PermanentMapper;
import cn.pasteme.common.utils.result.Response;
import cn.pasteme.common.utils.result.ResponseCode;
import org.springframework.stereotype.Service;

/**
 * @author Lucien, Irene
 * @version 1.2.1
 */
@Service
public class PermanentManagerImpl implements PermanentManager {

    private final PermanentMapper permanentMapper;

    public PermanentManagerImpl(PermanentMapper permanentMapper) {
        this.permanentMapper = permanentMapper;
    }

    @Override
    public Response<String> save(PasteRequestDTO pasteRequestDTO) {
        PermanentDO permanentDO = new PermanentDO();
        permanentDO.setLang(pasteRequestDTO.getLang());
        permanentDO.setContent(pasteRequestDTO.getContent());
        permanentDO.setPassword(pasteRequestDTO.getPassword());
        permanentDO.setClientIp(pasteRequestDTO.getClientIp());
        if (permanentMapper.create(permanentDO) == 1){
            return Response.success(String.valueOf(permanentDO.getKey()));
        } else {
            return Response.error(ResponseCode.SERVER_ERROR);
        }
    }

    @Override
    public Response<PasteResponseDTO> get(String key) {
        PermanentDO permanentDO = permanentMapper.getByKey(Long.valueOf(key));
        if (permanentDO != null) {
            if (null == permanentDO.getDeletedAt()) {
                PasteResponseDTO pasteResponseDTO = new PasteResponseDTO();
                pasteResponseDTO.setLang(permanentDO.getLang());
                pasteResponseDTO.setContent(permanentDO.getContent());
                return Response.success(pasteResponseDTO);
            }
            return Response.error(ResponseCode.FORBIDDEN);
        } else {
            return Response.error(ResponseCode.NOT_FOUND);
        }
    }

    @Override
    public Response erase(String key) {
        if (permanentMapper.countByKey(Long.valueOf(key)) == 0) {
            return Response.error(ResponseCode.NOT_FOUND);
        }
        if (permanentMapper.eraseByKey(Long.valueOf(key)) == 1) {
            return Response.success();
        }
        return Response.error(ResponseCode.SERVER_ERROR);
    }

    @Override
    public Response<Long> countAll() {
        return Response.success(permanentMapper.countAll());
    }

    @Override
    public Response<Long> getCurrentMaximumKey() {
        return Response.success(countAll().getData() + 100 - 1);
    }
}
