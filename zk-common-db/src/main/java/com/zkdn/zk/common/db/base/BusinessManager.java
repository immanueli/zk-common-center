package com.zkdn.zk.common.db.base;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:  基础manager
 * @Author:Brain
 * @Date:2018/12/28
 **/
public interface BusinessManager<T> {

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * 数据量多的情况不建议使用 存在性能问题
     * @param entity
     * @return
     */
    T selectOne(T entity);

    /**
     * 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     * @param id
     * @return
     */
    T selectById(Serializable id);

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * 数据量多的情况不建议使用 存在性能问题
     * @param entity
     * @return
     */
    List<T> selectList(T entity) ;

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * 数据量多的情况不建议使用 存在性能问题
     * @param entity
     * @return
     */
    Long selectCount(T entity);

    /**
     * 保存一个实体，null的属性不会保存，会使用数据库默认值
     * @param entity
     * @return
     */
    boolean insert(T entity);

    /**
     * 根据主键更新属性不为null的值
     * @param entity
     * @return
     */
    boolean updateById(T entity);

}
