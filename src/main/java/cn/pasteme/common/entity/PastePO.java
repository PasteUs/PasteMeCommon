package cn.pasteme.common.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by Lucien on 2019/10/01 02:11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PastePO extends TemporaryPO {

    private Date deletedAt;
}
