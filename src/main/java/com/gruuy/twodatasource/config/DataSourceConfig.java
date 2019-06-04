package com.gruuy.twodatasource.config;

import com.gruuy.twodatasource.datasource.DynamicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    /** DataSource1*/
    @Bean(name = "datasource1")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource dataSource1(){
        return DataSourceBuilder.create().build();
    }

    /** DataSource2*/
    @Bean(name = "datasource2")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }

    /** 配置动态数据源 */
    @Primary        /** 用此注解表示当有多个选择时，优先加载这个Bean */
    @Bean(name = "dynamicDataSource")       /** 注意这个名字，因为是代替原本的dynamicDataSource，所以必须要用这个名字 */
    public DataSource switchDataSource(){
        //这是我们要代替原本单数据源的dynamicDataSource
        DynamicDataSource dynamicDataSource=new DynamicDataSource();
        //默认test1
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());
        //配置多数据源
        Map<Object,Object> dsMap=new HashMap<>();
        dsMap.put("test1",dataSource1());
        dsMap.put("test2",dataSource2());
        //赋值多数据源并返回容器
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }
    /**
     * 配置@Transactional注解事物
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        //配置事务管理器管理我们创建的数据源
        return new DataSourceTransactionManager(switchDataSource());
    }
}
