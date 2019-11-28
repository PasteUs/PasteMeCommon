package cn.pasteme.common.manager.impl;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.entity.TemporaryDO;
import cn.pasteme.common.manager.TemporaryManager;
import cn.pasteme.common.mapper.TemporaryMapper;
import cn.pasteme.common.utils.BeansConverter;
import cn.pasteme.common.utils.result.Response;
import cn.pasteme.common.utils.result.ResponseCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Lucien, Irene, Moyu
 * @version 1.3.0
 */

@Slf4j
@Service
public class TemporaryManagerImpl implements TemporaryManager {

    private final TemporaryMapper temporaryMapper;

    public TemporaryManagerImpl(TemporaryMapper temporaryMapper) {
        this.temporaryMapper = temporaryMapper;
    }

    @Override
    public Response<String> save(PasteRequestDTO pasteRequestDTO) {
        TemporaryDO temporaryDO = new TemporaryDO();
        if (temporaryMapper.create(BeansConverter.dtoToDo(pasteRequestDTO, temporaryDO)) == 1){
            return Response.success(temporaryDO.getKey());
        } else {
            return Response.error(ResponseCode.SERVER_ERROR);
        }
    }

    @Override
    public Response<PasteResponseDTO> get(String key) {
        TemporaryDO temporaryDO = temporaryMapper.getByKey(key);
        if (temporaryDO != null) {
            Response response = erase(key);

            if (!response.isSuccess()) {
                log.error("Erase temporary after get failed, responseCode = ({}, {})", response.getCode(), response.getMessage());
            }

            PasteResponseDTO pasteResponseDTO = new PasteResponseDTO();

            return Response.success(BeansConverter.doToDto(temporaryDO, pasteResponseDTO));
        } else {
            return Response.error(ResponseCode.SERVER_ERROR);
        }
    }

    @Override
    public Response erase(String key) {
        if (temporaryMapper.countByKey(key) == 0) {
            return Response.error(ResponseCode.NOT_FOUND);
        } else {
            if (temporaryMapper.eraseByKey(key) == 1) {
                return Response.success();
            } else {
                return Response.error(ResponseCode.SERVER_ERROR);
            }
        }
    }

    @Override
    public Response<Long> countAll() {
        return Response.success(temporaryMapper.countAll());
    }
}
