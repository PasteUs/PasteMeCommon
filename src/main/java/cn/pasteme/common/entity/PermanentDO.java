package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author 白振宇
 * @version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PermanentDO extends AbstractPaste {

    private Long key;

    private Date deletedAt;
}
