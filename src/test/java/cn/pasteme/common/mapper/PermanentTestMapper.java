package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author Irene
 * @version 1.0.0
 */
@Mapper
@Component
public interface PermanentTestMapper {

    @Update("CREATE TABLE IF NOT EXISTS `permanents` (" +
            "    `key` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY," +
            "    `lang` VARCHAR(16) NULL," +
            "    `content` MEDIUMTEXT NULL," +
            "    `password` VARCHAR(32) NULL," +
            "    `client_ip` VARCHAR(64) NULL," +
            "    `created_at` TIMESTAMP NULL," +
            "    `deleted_at` TIMESTAMP NULL" +
            ")" +
            "    COLLATE=utf8mb4_general_ci" +
            "    ENGINE=Innodb" +
            "    DEFAULT CHARSET=utf8mb4" +
            "    AUTO_INCREMENT=100;")
    void createTable();

    @Insert("CREATE INDEX `idx` ON `permanents` (`key`);")
    void createIndex();

    @Insert("INSERT INTO `permanents` (`key`, `content`, `lang`, `password`, `client_ip`, `created_at`) " +
            "VALUE (#{key}, #{content}, #{lang}, #{password}, #{clientIp}, now())")
    Long create(PermanentDO permanentDO);

    @Delete("DELETE FROM `permanents` WHERE `key` = #{key}")
    Long delete(Long key);
}
