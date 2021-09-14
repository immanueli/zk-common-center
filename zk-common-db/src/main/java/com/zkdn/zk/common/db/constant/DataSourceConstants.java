package com.zkdn.zk.common.db.constant;


import com.zkdn.zk.common.core.constant.CommonConstants;

/**
 * @Description: 数据源相关常量
 * @Author:Brain
 * @Date:2018/12/29
 **/
public class DataSourceConstants {

    /**主键名称*/
    public static final String PRIMARY_KEY_NAME = "id";

    /**druid连接池初始化方法*/
    public static final String DATASOURCE_DRUID_INIT_METHOD = "init";

    /**druid连接池销毁方法*/
    public static final String DATASOURCE_DRUID_DESTORY_METHOD = "close";

    /**主数据源配置前缀*/
    public static final String DATASOURCE_MASTER_CONFIGRATION_PREFIX = "master.datasource.druid";

    /**从数据源配置前缀*/
    public static final String DATASOURCE_CLUSTER_CONFIGRATION_PREFIX = "cluster.datasource.druid";

    /**主数据源mapper接口扫描包*/
    public static final String DATASOURCE_MASTER_MAPPER_I_PACKAGE = CommonConstants.BASE_SCAN_PACKAGE + ".**.data.mapper.master";

    /**从数据源mapper接口扫描包*/
    public static final String DATASOURCE_CLUSTER_MAPPER_I_PACKAGE = CommonConstants.BASE_SCAN_PACKAGE + ".**.data.mapper.cluster";

    /**主数据源mapper配置扫描包*/
    public static final String DATASOURCE_MASTER_MAPPER_C_PACKAGE = "classpath*:mappers/master/*.xml";

    /**从数据源mapper配置扫描包*/
    public static final String DATASOURCE_CLUSTER_MAPPER_C_PACKAGE = "classpath*:mappers/cluster/*.xml";

    /**主数据源名称*/
    public static final String DATASOURCE_MASTER_NAME = "masterDataSource";

    /**从数据源名称*/
    public static final String DATASOURCE_CLUSTER_NAME = "clusterDataSource";

    /**主数据源事务管理器名称*/
    public static final String DATASOURCE_MASTER_TRANSACTION_MANAGER_NAME = "masterTransactionManager";

    /**从数据源事务管理器名称*/
    public static final String DATASOURCE_CLUSTER_TRANSACTION_MANAGER_NAME = "clusterTransactionManager";

    /**主数据源mybatis工厂实例名称*/
    public static final String DATASOURCE_MASTER_SESSION_FACTORY_NAME = "masterSqlSessionFactory";

    /**从数据源mybatis工厂实例名称*/
    public static final String DATASOURCE_CLUSTER_SESSION_FACTORY_NAME = "clusterSqlSessionFactory";
}
