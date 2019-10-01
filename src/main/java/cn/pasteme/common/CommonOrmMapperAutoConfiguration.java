package cn.pasteme.common;

import cn.pasteme.common.mapper.MybatisMapperBase;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackageClasses = MybatisMapperBase.class)
public class CommonOrmMapperAutoConfiguration {
}
