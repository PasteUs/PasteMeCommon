package cn.pasteme.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 白振宇
 * @Date： 2019/9/30 0:47
 */
@Data
public class Permanent {
    private Long key;
    private String lang;
    private String content;
    private String password;
    private String clientIP;
    private Date createdAt;
    private Date deletedAt;
}
