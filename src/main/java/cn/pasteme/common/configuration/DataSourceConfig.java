package cn.pasteme.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Lucien
 * @version 1.0.0
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "mysql")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }
}
