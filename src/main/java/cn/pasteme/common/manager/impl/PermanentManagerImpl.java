package cn.pasteme.common.manager.impl;

import cn.pasteme.common.dto.PasteRequestDTO;
import cn.pasteme.common.dto.PasteResponseDTO;
import cn.pasteme.common.entity.PermanentDO;
import cn.pasteme.common.enumeration.FieldEnum;
import cn.pasteme.common.manager.PermanentManager;
import cn.pasteme.common.mapper.PermanentMapper;
import cn.pasteme.common.utils.converter.DoToDtoConverter;
import cn.pasteme.common.utils.converter.DtoToDoConverter;
import cn.pasteme.common.utils.result.Response;
import cn.pasteme.common.utils.result.ResponseCode;
import org.springframework.stereotype.Service;

/**
 * @author Lucien, Irene, Moyu
 * @version 1.3.2
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
        if (permanentMapper.create(DtoToDoConverter.convert(pasteRequestDTO, permanentDO, FieldEnum.FIELD_KEY.getName())) == 1){
            return Response.success(String.valueOf(permanentDO.getKey()));
        } else {
            return Response.error(ResponseCode.SERVER_ERROR);
        }
    }

    @Override
    public Response<PasteResponseDTO> get(String key) {
        PermanentDO permanentDO = permanentMapper.getByKey(Long.valueOf(key));
        if (permanentDO == null) {
            return Response.error(ResponseCode.NOT_FOUND);
        } else if (permanentDO.getDeletedAt() != null) {
            return Response.error(ResponseCode.FORBIDDEN);
        } else {
            PasteResponseDTO pasteResponseDTO = new PasteResponseDTO();
            return Response.success(DoToDtoConverter.convert(permanentDO, pasteResponseDTO));
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
    public Response<Long> countByKey(String key) {
        return Response.success(permanentMapper.countByKey(Long.valueOf(key)));
    }

    @Override
    public Response<Long> getCurrentMaximumKey() {
        return Response.success(permanentMapper.getMaxKey());
    }
}
