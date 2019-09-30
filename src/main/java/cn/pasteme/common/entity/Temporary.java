package cn.pasteme.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 白振宇
 * @Date： 2019/9/30 0:48
 */
@Data
public class Temporary {
    private String key;
    private String lang;
    private String content;
    private String password;
    private String clientIP;
    private Date createdAt;
}
