package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author 白振宇
 * @date 2019/9/30 00:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PermanentPO extends Paste {

    private Long key;

    private Date deletedAt;
}
