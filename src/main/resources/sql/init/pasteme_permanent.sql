CREATE TABLE IF NOT EXISTS `pasteme_permanent`
(
    `key`        BIGINT UNSIGNED NOT NULL COMMENT '主键' AUTO_INCREMENT PRIMARY KEY,
    `lang`       VARCHAR(16)     NOT NULL COMMENT '高亮类型',
    `content`    MEDIUMTEXT      NOT NULL COMMENT '内容',
    `password`   VARCHAR(32)     NOT NULL COMMENT '密码，默认为空串' DEFAULT '',
    `client_ip`  VARCHAR(64)     NOT NULL COMMENT '创建者的 IP',
    `created_at` TIMESTAMP       NOT NULL COMMENT '创建时间',
    `deleted_at` TIMESTAMP       NULL COMMENT '删除时间，如果为 NULL 说明还没有删除'
) COLLATE = utf8mb4_general_ci
  ENGINE = Innodb
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 100;
