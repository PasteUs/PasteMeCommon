package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 白振宇
 * @date 2019/09/30 00:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TemporaryDO extends AbstractPaste {

    private String key;
}
