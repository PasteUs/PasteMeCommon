package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 白振宇
 * @date 2019/9/30 00:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TemporaryPO extends Paste {

    private String key;
}
