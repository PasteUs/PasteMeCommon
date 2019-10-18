package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author Lucien
 * @version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PasteDO extends AbstractPaste {

    private String key;

    private Date deletedAt;
}
