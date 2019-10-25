package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 白振宇
 * @version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TemporaryDO extends AbstractPaste {

    private String key;
}
