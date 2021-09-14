package com.zkdn.zk.common.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zkdn.zk.common.db.constant.DataSourceConstants;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhangchunhao
 * @version 1.0
 * @date 2021/9/14
 * @apiNote 从数据源配置
 **/
@Configuration
@ConfigurationProperties(prefix = DataSourceConstants.DATASOURCE_CLUSTER_CONFIGRATION_PREFIX)
@MapperScan(basePackages = DataSourceConstants.DATASOURCE_CLUSTER_MAPPER_I_PACKAGE, sqlSessionFactoryRef = DataSourceConstants.DATASOURCE_CLUSTER_SESSION_FACTORY_NAME)
public class ClusterDataBaseConfig extends BaseDataBaseConfig {


    /**
     * 从数据源
     * @return
     */
    @Bean(name = DataSourceConstants.DATASOURCE_CLUSTER_NAME,destroyMethod = DataSourceConstants.DATASOURCE_DRUID_DESTORY_METHOD,initMethod = DataSourceConstants.DATASOURCE_DRUID_INIT_METHOD)
    public DruidDataSource clusterDataSource() throws Exception {
        return initDataSource();
    }

    /**
     * 从数据源的事务管理
     * @return
     */
    @Bean(name = DataSourceConstants.DATASOURCE_CLUSTER_TRANSACTION_MANAGER_NAME)
    public DataSourceTransactionManager masterTransactionManager(@Qualifier(DataSourceConstants.DATASOURCE_CLUSTER_NAME) DataSource dataSource) {
        return initTransactionManager(dataSource);
    }

    /**
     * mybatis工厂实例
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = DataSourceConstants.DATASOURCE_CLUSTER_SESSION_FACTORY_NAME)
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier(DataSourceConstants.DATASOURCE_CLUSTER_NAME)DataSource dataSource) throws Exception{
        return initSqlSessionFactory(dataSource,DataSourceConstants.DATASOURCE_CLUSTER_MAPPER_C_PACKAGE);
    }

}
