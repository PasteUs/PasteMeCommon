package cn.pasteme.common;

import cn.pasteme.common.mapper.MybatisMapperBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ryan Lee
 * @date 2019/10/01 17:01
 */
@Configuration
@MapperScan(basePackageClasses = MybatisMapperBase.class)
public class CommonOrmMapperAutoConfiguration {
}
