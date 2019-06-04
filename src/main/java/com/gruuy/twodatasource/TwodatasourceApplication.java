package com.gruuy.twodatasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 添加(exclude = { DataSourceAutoConfiguration.class })是为了禁掉springboot自带
 * 的DataSourceAutoConfiguration，因为它会默认读取apliication.properties的spring.datasource.*
 * 属性并自动配置单数据源
 * EnableScheduling 这破玩意是@Scheduled定时器执行的必要条件
 * @author huangsz on 2018/7/16 0016 14:33
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan(basePackages = "com.gruuy.twodatasource.dao")
public class TwodatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwodatasourceApplication.class, args);
    }

}
