package com.zkdn.zk.common.db.config;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhangchunhao
 * @version 1.0
 * @date 2021/9/14
 * @apiNote 基础数据源配置
 **/
@Data
@Slf4j
public class BaseDataBaseConfig {


    /**拦截的filters*/
    private String filters;

    /**数据库url*/
    private String url;

    /**数据库用户名*/
    private String username;

    /**数据库密码*/
    private String password;

    /**数据库驱动*/
    private String driverClassName;

    /**初始化时简历物理连接个数*/
    private int initialSize;

    /**最小连接数*/
    private int minIdle;

    /**最大连接数*/
    private int maxActive;

    /**获取连接时最大等待时间 单位 毫秒*/
    private long maxWait;

    /**间隔多久进行一次检测(检测需要关闭的空闲连接)*/
    private long timeBetweenEvictionRunsMillis;

    /**一个连接在池中最小生存的时间*/
    private long minEvictableIdleTimeMillis;

    /**检测连接是否有效sql*/
    private String validationQuery;

    /**空闲时校验，建议开启*/
    private boolean testWhileIdle;

    /**使用中是否校验有效性，推荐关闭效*/
    private boolean testOnBorrow;

    /**归还连接时校验有效性，推荐关闭*/
    private boolean testOnReturn;

    /**是否缓存preparedStatement oracle true mysql false*/
    private boolean poolPreparedStatements;

    /**统计所有数据源状态*/
    private boolean useGlobalDataSourceStat;

    /***/
    private String connectionProperties;

    private String publicKey;

    private boolean encrypt;
    /**
     * 初始化数据源
     * @return
     * @throws Exception
     */
    public DruidDataSource initDataSource() throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters(filters);
        druidDataSource.setUsername(username);
        if(!encrypt) {
            druidDataSource.setPassword(password);
        }else{
            druidDataSource.setPassword(ConfigTools.decrypt(publicKey, password));
        }
        druidDataSource.setUrl(url);
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);
        druidDataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        druidDataSource.setConnectionProperties(connectionProperties);
        return  druidDataSource;
    }


    /**
     * 初始化数据源事务管理器
     * @param dataSource
     * @return
     */
    public DataSourceTransactionManager initTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 初始化数据源mybatis工厂实例
     * @param dataSource
     * @param mapperResourcePath
     * @return
     * @throws Exception
     */
    public SqlSessionFactory initSqlSessionFactory(DataSource dataSource, String mapperResourcePath) throws Exception{
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        mybatisSqlSessionFactoryBean.setPlugins(new Interceptor[]{new PaginationInterceptor().setDialectType(DbType.MYSQL.getDb())});
        mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperResourcePath));
        return mybatisSqlSessionFactoryBean.getObject();
    }


}
