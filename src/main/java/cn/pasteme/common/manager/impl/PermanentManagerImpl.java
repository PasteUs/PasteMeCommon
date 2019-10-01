package cn.pasteme.common.manager.impl;

import cn.pasteme.common.dao.PermanentDAO;
import cn.pasteme.common.dto.PasteContentDTO;
import cn.pasteme.common.entity.PasteDO;
import cn.pasteme.common.manager.PermanentManager;
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
public class PermanentManagerImpl implements PermanentManager {

    private final PermanentDAO permanentDAO;

    public PermanentManagerImpl(PermanentDAO permanentDAO) {
        this.permanentDAO = permanentDAO;
    }

    @Override
    public PasteContentDTO getPasteContentByKey(Long key, String pwd) {
        Optional<PasteDO> pasteDO = Optional.ofNullable(permanentDAO.get(key + ""));
        PasteContentDTO contentDTO = new PasteContentDTO();
        return PwdMatch.match(pasteDO, contentDTO, pwd);
    }
}
