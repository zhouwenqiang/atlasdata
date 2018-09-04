package com.atlas.common;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/17.
 */
@Configuration
//@MapperScan("com.atlas.mapper")
public class DataSourceConfig {
    public static final String ORACLE_DS1 = "mysqlDS1";
    @Bean(name= ORACLE_DS1)
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    @Primary
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name="oracleDS1")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "dataSource")
    public DataSource dataSource(){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        // 配置多数据源
        Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("mysqlDS1", dataSource1());
        dsMap.put("oracleDS1", dataSource2());
        dynamicDataSource.setTargetDataSources(dsMap);

        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());


        return dynamicDataSource;
    }

}
