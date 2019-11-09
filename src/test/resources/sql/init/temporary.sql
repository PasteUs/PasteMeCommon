CREATE TABLE IF NOT EXISTS `temporaries`
(
    `key`        VARCHAR(16) NOT NULL PRIMARY KEY,
    `lang`       VARCHAR(16) NOT NULL,
    `content`    MEDIUMTEXT  NOT NULL,
    `password`   VARCHAR(32) NOT NULL DEFAULT '',
    `client_ip`  VARCHAR(64) NOT NULL,
    `created_at` TIMESTAMP   NULL
) COLLATE = utf8mb4_general_ci
  ENGINE = Innodb
  DEFAULT CHARSET = utf8mb4;
