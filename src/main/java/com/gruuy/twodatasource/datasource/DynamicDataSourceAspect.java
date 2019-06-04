package com.gruuy.twodatasource.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 注解切面处理类
 */
@Aspect     /** 标记是一个切面类 */
@Component  /** 同时又装载到容器中 */
public class DynamicDataSourceAspect {

    Logger logger= LoggerFactory.getLogger(DynamicDataSource.class);

    public DynamicDataSourceAspect(){
        logger.info("=============初始化AOP===============");
    }

    @Before("@annotation(com.gruuy.twodatasource.datasource.DS)")  /** 当有DS注解的方法跑之前 */
    public void beforeSwitchDS(JoinPoint point){    /** JoinPoint可以获取被注解方法的各种信息，例如方法名，参数等 */
//        /** 获取当前注解方法的Class */
//        Class<?> className=point.getTarget().getClass();
//
//        /** 获取当前注解方法的名称 */
//        String methodName=point.getSignature().getName();
//
//        /** 获取当前注解方法的参数类型 */
//        Class[] argClass=((MethodSignature)point.getSignature()).getParameterTypes();

        DS datasource=((MethodSignature)point.getSignature()).getMethod().getAnnotation(DS.class);
        System.out.println(datasource.value());
        if(datasource.value()==null||datasource.value().equals("")){
            DataSourceContextUtils.setDB(DataSourceContextUtils.DEFAULT_DS);
        }else {
            DataSourceContextUtils.setDB(datasource.value());
        }
    }
    @After("@annotation(com.gruuy.twodatasource.datasource.DS)")
    public void afterSwitchDS(JoinPoint point){
        DataSourceContextUtils.removeDB();
    }
}
