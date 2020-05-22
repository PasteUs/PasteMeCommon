CREATE TABLE IF NOT EXISTS `pasteme_temporary`
(
    `key`        VARCHAR(16) NOT NULL COMMENT '主键' PRIMARY KEY,
    `lang`       VARCHAR(16) NOT NULL COMMENT '高亮类型',
    `content`    MEDIUMTEXT  NOT NULL COMMENT '内容',
    `password`   VARCHAR(32) NOT NULL COMMENT '密码，默认为空串' DEFAULT '',
    `client_ip`  VARCHAR(64) NOT NULL COMMENT '创建者的 IP',
    `created_at` TIMESTAMP   NOT NULL COMMENT '创建时间'
) COLLATE = utf8mb4_general_ci
  ENGINE = Innodb
  DEFAULT CHARSET = utf8mb4;
