package com.zkdn.zk.common.db.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
* @author zhangchunhao
* @apiNote 基础mapper实现类
* @date 19:04 2021/9/14
* @param
* @return
**/
public abstract class BaseBusinessManagerImpl<Master extends BaseMapper<T>,Cluster extends BaseMapper<T>,T> implements BusinessManager<T> {

    @Autowired
    private Master master;

    @Autowired
    private Cluster cluster;

    @Override
    public T selectOne(T entity) {
        return cluster.selectOne(new QueryWrapper<>(entity));
    }

    @Override
    public T selectById(Serializable id) {
        return cluster.selectById(id);
    }

    @Override
    public List<T> selectList(T entity) {
        return cluster.selectList(new QueryWrapper<>(entity));
    }

    @Override
    public Long selectCount(T entity) {
        return new Long(cluster.selectCount(new QueryWrapper<>(entity)));
    }

    @Override
    public boolean insert(T entity) {
        int insertFlag = master.insert(entity);
        return insertFlag>0?true:false;
    }

    @Override
    public boolean updateById(T entity) {
        int updateFlag = master.updateById(entity);
        return updateFlag>0?true:false;
    }

    protected Master getMasterMapper(){
        return this.master;
    }

    protected Cluster getClusterMapper(){
        return this.cluster;
    }
}
