package com.gruuy.twodatasource.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class DataSourceContextUtils {
    /** 日志*/
    public static final Logger logger= LoggerFactory.getLogger(DataSourceContextUtils.class);

    /** 默认数据源 */
    public static final String DEFAULT_DS="test1";

    /** 每个访问服务器的线程都拥有一个独立的变量副本，这个副本是数据源的名称，默认就是上面那个，互相独立互不影响 */
    private static final ThreadLocal<String> contextHolder=new ThreadLocal<>();

    /** 修改数据源名称的方法 */
    public static void setDB(String dbType){
        logger.debug("切换到"+dbType+"数据源");
        contextHolder.set(dbType);
    }
    /** 获取数据源名的方法 */
    public static String getDB(){
        return contextHolder.get();
    }
    /** 清除数据源名称 */
    public static void removeDB(){
        contextHolder.remove();
    }
}
