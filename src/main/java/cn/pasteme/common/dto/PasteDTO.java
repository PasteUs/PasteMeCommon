package cn.pasteme.common.dto;

import cn.pasteme.common.entity.TemporaryDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author Lucien
 * @date 2019/10/01 02:07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PasteDTO extends TemporaryDO {

    private Date deletedAt;
}
