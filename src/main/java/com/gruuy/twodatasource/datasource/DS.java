package com.gruuy.twodatasource.datasource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，再利用AOP进行处理，切换数据源
 */
@Retention(RetentionPolicy.RUNTIME)  //表明编译后，运行后该注解依然存在(因为需要动态切换，所以运行时也必须存在)
@Target(ElementType.METHOD) //表明只能注解在方法上
public @interface DS{
    String value() default "test1"; //默认值为test1
}
