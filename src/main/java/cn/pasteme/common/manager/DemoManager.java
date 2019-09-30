package cn.pasteme.common.manager;

import cn.pasteme.common.dto.TokenDTO;
import cn.pasteme.common.entity.Permanent;
import cn.pasteme.common.entity.Temporary;
import cn.pasteme.common.mapper.PermanentsMapper;
import cn.pasteme.common.mapper.TemporariesMapper;
import cn.pasteme.common.utils.Md5Util;
import cn.pasteme.common.vo.ContentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: 白振宇
 * @Date： 2019/9/30 19:32
 */
@Service
public class DemoManager {
    private final PermanentsMapper permanentsMapper;
    private final TemporariesMapper temporariesMapper;

    public DemoManager(PermanentsMapper permanentsMapper, TemporariesMapper temporariesMapper) {
        this.permanentsMapper = permanentsMapper;
        this.temporariesMapper = temporariesMapper;
    }

    public ContentVO getContentByKey(TokenDTO tokenDTO) {
        ContentVO contentVO = new ContentVO();
        try {
            long key = Long.valueOf(tokenDTO.getKey());
            Optional<Permanent> permanent = Optional.ofNullable(permanentsMapper.getByKeyPermanent(key));
            permanent.filter(p -> {
                boolean flag = false;
                try {
                    flag = p.getPassword()==null || p.getPassword().isEmpty() || (tokenDTO.getPwd()!=null && !tokenDTO.getPwd().isEmpty() && Md5Util.getMD5Str(tokenDTO.getPwd()).equals(p.getPassword()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return flag;
            }).ifPresent(p -> {
                BeanUtils.copyProperties(p, contentVO);
                contentVO.setKey(tokenDTO.getKey());
            });
        } catch (NumberFormatException e) {
            Optional<Temporary> temporary = Optional.ofNullable(temporariesMapper.getByKeyTemporary(tokenDTO.getKey()));
            temporary.ifPresent(t -> BeanUtils.copyProperties(temporary, contentVO));
        }
        return contentVO;
    }
}
