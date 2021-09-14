package com.zkdn.zk.common.db.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.zkdn.zk.common.db.constant.DataSourceConstants;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
* @author zhangchunhao
* @apiNote 基础信息模型
* @date 19:10 2021/9/14
* @param
* @return
**/
@Data
public abstract class BaseBusinessModel implements Serializable {

    /**主键*/
    @TableId(value = DataSourceConstants.PRIMARY_KEY_NAME, type = IdType.AUTO)
    private Long id;

    /**创建时间*/
    private Date createTime;

    /**创建人*/
    private Long createId;

    /**更新时间*/
    private Date updateTime;

    /**更新人*/
    private Long updateId;

    /**备注*/
    private String remark;
    /**
     * 1 删除 0未删除
     */
    @TableLogic(value= "0",delval = "1")
    private  Integer isDelete;

}
