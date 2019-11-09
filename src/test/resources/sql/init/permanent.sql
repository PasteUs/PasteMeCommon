CREATE TABLE IF NOT EXISTS `permanents`
(
    `key`        BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `lang`       VARCHAR(16)     NOT NULL,
    `content`    MEDIUMTEXT      NOT NULL,
    `password`   VARCHAR(32)     NOT NULL DEFAULT '',
    `client_ip`  VARCHAR(64)     NOT NULL,
    `created_at` TIMESTAMP       NOT NULL,
    `deleted_at` TIMESTAMP       NULL
) COLLATE = utf8mb4_general_ci
  ENGINE = Innodb
  DEFAULT CHARSET = utf8mb4
  AUTO_INCREMENT = 100;
