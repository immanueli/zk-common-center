package com.zkdn.zk.common.db.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.zkdn.zk.common.db.constant.DataSourceConstants;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangchunhao
 * @version 1.0
 * @date 2021/9/14
 * @apiNote 主数据源配置
 **/
@Configuration
@ConfigurationProperties(prefix = DataSourceConstants.DATASOURCE_MASTER_CONFIGRATION_PREFIX)
@MapperScan(basePackages = DataSourceConstants.DATASOURCE_MASTER_MAPPER_I_PACKAGE, sqlSessionFactoryRef = DataSourceConstants.DATASOURCE_MASTER_SESSION_FACTORY_NAME)
public class MasterDataBaseConfig extends BaseDataBaseConfig {

    /**
     * 主数据源
     *
     * @return
     * @throws SQLException
     */
    @Primary
    @Bean(name = DataSourceConstants.DATASOURCE_MASTER_NAME, destroyMethod = DataSourceConstants.DATASOURCE_DRUID_DESTORY_METHOD, initMethod = DataSourceConstants.DATASOURCE_DRUID_INIT_METHOD)
    public DruidDataSource masterDataSource() throws Exception {
        return initDataSource();
    }


    /**
     * 主数据源的事务管理
     *
     * @return
     * @throws SQLException
     */
    @Primary
    @Bean(name = DataSourceConstants.DATASOURCE_MASTER_TRANSACTION_MANAGER_NAME)
    public DataSourceTransactionManager masterTransactionManager(@Qualifier(DataSourceConstants.DATASOURCE_MASTER_NAME) DataSource dataSource) {
        return initTransactionManager(dataSource);
    }

    /**
     * mybatis工厂实例
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Primary
    @Bean(name = DataSourceConstants.DATASOURCE_MASTER_SESSION_FACTORY_NAME)
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier(DataSourceConstants.DATASOURCE_MASTER_NAME) DataSource dataSource) throws Exception {
        return initSqlSessionFactory(dataSource, DataSourceConstants.DATASOURCE_MASTER_MAPPER_C_PACKAGE);
    }

    /**
     * 逻辑删除插件
     *
     * @return LogicSqlInjector
     */
    @Bean
    @ConditionalOnMissingBean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String, String> params = new HashMap<>(2);
        params.put("loginUsername", "root");
        params.put("loginPassword", "123456");
        bean.setInitParameters(params);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.addUrlPatterns("/*");
        Map<String, String> params = new HashMap<>(1);
        params.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(params);
        return bean;
    }


}
