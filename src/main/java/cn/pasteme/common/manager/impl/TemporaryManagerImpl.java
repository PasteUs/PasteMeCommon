package cn.pasteme.common.manager.impl;

import cn.pasteme.common.dao.TemporaryDAO;
import cn.pasteme.common.dto.PasteContentDTO;
import cn.pasteme.common.entity.PasteDO;
import cn.pasteme.common.entity.TemporaryDO;
import cn.pasteme.common.manager.TemporaryManager;
import cn.pasteme.common.utils.Md5;
import cn.pasteme.common.utils.PwdMatch;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: 白振宇
 * @Date： 2019/10/2 0:56
 */
@Service
public class TemporaryManagerImpl implements TemporaryManager {

    private final TemporaryDAO temporaryDAO;

    public TemporaryManagerImpl(TemporaryDAO temporaryDAO) {
        this.temporaryDAO = temporaryDAO;
    }

    @Override
    public PasteContentDTO getPasteContentByKey(String key, String pwd) {
        Optional<PasteDO> pasteDO = Optional.ofNullable(temporaryDAO.get(key));
        PasteContentDTO contentDTO = new PasteContentDTO();
        return PwdMatch.match(pasteDO, contentDTO, pwd);
    }
}
