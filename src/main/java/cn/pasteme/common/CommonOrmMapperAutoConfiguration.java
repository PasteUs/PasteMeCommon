package cn.pasteme.common;

import cn.pasteme.common.mapper.MybatisMapperBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan Lee
 * @version 1.0.0
 */
@Configuration
@MapperScan(basePackageClasses = MybatisMapperBase.class)
public class CommonOrmMapperAutoConfiguration {
}
