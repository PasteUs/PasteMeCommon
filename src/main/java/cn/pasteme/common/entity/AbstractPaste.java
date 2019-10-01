package cn.pasteme.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Lucien
 * @date 2019/10/01 01:58
 */
@Data
abstract class AbstractPaste {

    private String lang;

    private String content;

    private String password;

    private String clientIp;

    private Date createdAt;
}

