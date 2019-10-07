package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.TemporaryDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author Irene
 * @date 2019/10/06 00:55
 */
@Mapper
@Component
public interface TemporaryTestMapper {
    @Update("CREATE TABLE IF NOT EXISTS `temporaries` (" +
            "    `key` VARCHAR(16) DEFAULT '' NOT NULL PRIMARY KEY," +
            "    `lang` VARCHAR(16) NULL," +
            "    `content` MEDIUMTEXT NULL," +
            "    `password` VARCHAR(32) NULL," +
            "    `client_ip` VARCHAR(64) NULL," +
            "    `created_at` TIMESTAMP NULL" +
            ")" +
            "    COLLATE=utf8mb4_general_ci" +
            "    ENGINE=Innodb" +
            "    DEFAULT CHARSET=utf8mb4;")
    void createTable();

    @Insert("CREATE INDEX `idx` ON `temporaries` (`key`);")
    void createIndex();

    @Insert("INSERT INTO `temporaries` " +
            "(`key`, `lang`, `content`, `password`, `client_ip`, `created_at`) " +
            "VALUE (#{key}, #{lang}, #{content}, #{password}, #{clientIp}, now())")
    Long insert (TemporaryDO temporaryDO);

    @Delete("DELETE FROM `temporaries` WHERE `key` = #{key}")
    Long delete (String key);

}
