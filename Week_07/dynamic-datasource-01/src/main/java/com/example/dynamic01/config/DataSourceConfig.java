package com.example.dynamic01.config;

import com.example.dynamic01.enums.DataSourceTypeEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource slaveDataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource targetDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                       @Qualifier("slaveDataSource1") DataSource slaveDataSource1) {

        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceTypeEnum.MASTER, masterDataSource);
        targetDataSource.put(DataSourceTypeEnum.SLAVE, slaveDataSource1);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //绑定所有数据源
        dynamicDataSource.setTargetDataSources(targetDataSource);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);

        return dynamicDataSource;
    }

}
