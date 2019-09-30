package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by 白振宇 on 2019/9/30 00:48
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TemporaryPO extends Paste {

    private String key;
}
