package cn.pasteme.common.mapper;

import cn.pasteme.common.entity.PermanentDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * @author Irene
 * @date 2019/10/05 21:44
 */
@Mapper
@Component
public interface PermanentTestMapper {

    @Update("CREATE TABLE IF NOT EXISTS `permanents` (\n" +
            "    `key` BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,\n" +
            "    `lang` VARCHAR(16) NULL,\n" +
            "    `content` MEDIUMTEXT NULL,\n" +
            "    `password` VARCHAR(32) NULL,\n" +
            "    `client_ip` VARCHAR(64) NULL,\n" +
            "    `created_at` TIMESTAMP NULL,\n" +
            "    `deleted_at` TIMESTAMP NULL\n" +
            ")\n" +
            "    COLLATE=utf8mb4_general_ci\n" +
            "    ENGINE=Innodb\n" +
            "    DEFAULT CHARSET=utf8mb4\n" +
            "    AUTO_INCREMENT=100;\n" +
            "\n" +
            "CREATE INDEX `idx`\n" +
            "    ON `permanents` (`key`);")
    void createTable();

    @Insert("INSERT INTO `pasteme`.`permanents` (`key`, `content`, `lang`, `password`, `created_at`) " +
            "VALUE (#{key}, #{content}, #{lang}, #{password}, now())")
    Long create(PermanentDO permanentDO);

    @Delete("DELETE FROM `pasteme`.`permanents` WHERE `key` = #{key}")
    Long delete(Long key);
}
