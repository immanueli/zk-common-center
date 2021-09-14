package com.zkdn.zk.common.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* @author zhangchunhao
* @apiNote 数据库字段枚举
* @date 19:02 2021/9/14
* @param
* @return
**/
@Getter
@AllArgsConstructor
public enum DbCommonEnum {

    DB_DELETE_NEVER(0,"未删除"),

    DB_DELETE_YET(1,"已删除"),

    DB_ENABLE_ON(0,"启用"),

    DB_ENABLE_OFF(1,"禁用"),

    DB_STATUS_INIT(0,"初始化");

    private Integer code;

    private String value;

}
