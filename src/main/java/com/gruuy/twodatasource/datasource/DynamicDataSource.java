package com.gruuy.twodatasource.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 继承AbstractRoutingDataSource 其实现DataSource接口
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final Logger log= LoggerFactory.getLogger(DynamicDataSource.class);


    /** 就是这里设置的数据源  不要被Object迷惑了 */
  @Override
    protected Object determineCurrentLookupKey() {
        logger.debug("数据源为"+DataSourceContextUtils.getDB());
        return DataSourceContextUtils.getDB();
    }
}
