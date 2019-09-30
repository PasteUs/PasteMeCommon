package cn.pasteme.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by Lucien on 2019/10/01 01:58
 */
@Data
abstract class Paste {

    private String lang;

    private String content;

    private String password;

    private String clientIP;

    private Date createdAt;
}

