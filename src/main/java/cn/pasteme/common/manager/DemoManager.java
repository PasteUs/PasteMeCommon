package cn.pasteme.common.manager;

import cn.pasteme.common.dto.TokenDTO;
import cn.pasteme.common.entity.PermanentDO;
import cn.pasteme.common.entity.TemporaryDO;
import cn.pasteme.common.mapper.PermanentMapper;
import cn.pasteme.common.mapper.TemporaryMapper;
import cn.pasteme.common.utils.Md5Util;
import cn.pasteme.common.vo.ContentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 白振宇
 * @date 2019/9/30 19:32
 */
@Service
public class DemoManager {
    private final PermanentMapper permanentMapper;
    private final TemporaryMapper temporaryMapper;

    public DemoManager(PermanentMapper permanentMapper, TemporaryMapper temporaryMapper) {
        this.permanentMapper = permanentMapper;
        this.temporaryMapper = temporaryMapper;
    }

    public ContentVO getContentByKey(TokenDTO tokenDTO) {
        ContentVO contentVO = new ContentVO();
        try {
            long key = Long.valueOf(tokenDTO.getKey());
            Optional<PermanentDO> permanent = Optional.ofNullable(permanentMapper.getByKeyPermanent(key));
            permanent.filter(p -> {
                boolean flag = false;
                try {
                    flag = p.getPassword() == null || p.getPassword().isEmpty() || (tokenDTO.getPwd() != null && !tokenDTO.getPwd().isEmpty() && Md5Util.getMD5Str(tokenDTO.getPwd()).equals(p.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return flag;
            }).ifPresent(p -> {
                BeanUtils.copyProperties(p, contentVO);
                contentVO.setKey(tokenDTO.getKey());
            });
        } catch (NumberFormatException e) {
            Optional<TemporaryDO> temporary = Optional.ofNullable(temporaryMapper.getByKeyTemporary(tokenDTO.getKey()));
            temporary.ifPresent(t -> BeanUtils.copyProperties(temporary, contentVO));
        }
        return contentVO;
    }
}
