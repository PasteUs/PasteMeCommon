package cn.pasteme.common.configuration;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author Lucien
 * @version 1.0.0
 */
@Configuration
@Slf4j
@MapperScan(basePackages = {"cn.pasteme.common.mapper"},
        sqlSessionTemplateRef = "getSqlSessionTemplate")
public class MapperConfiguration {

    private final DataSource dataSource;

    public MapperConfiguration(@Qualifier("mysql") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        Resource[] resources = new PathMatchingResourcePatternResolver().getResources(
                "classpath:sql/mapper/*.xml");

        log.debug("resources length is {}", resources.length);

        for(Resource r : resources){
            log.debug("{}: {}", r.getFilename(), r.getURL());
        }

        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate getSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(this.getSqlSessionFactory());
    }
}
