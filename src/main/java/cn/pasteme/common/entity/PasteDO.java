package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author Lucien
 * @date 2019/10/01 02:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PasteDO extends AbstractPaste {

    private String key;

    private Date deletedAt;
}
