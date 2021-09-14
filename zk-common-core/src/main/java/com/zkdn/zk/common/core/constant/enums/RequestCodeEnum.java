package com.zkdn.zk.common.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* @author zhangchunhao
* @apiNote 请求信息
* @date 19:31 2021/9/14
* @param
* @return
**/
@Getter
@AllArgsConstructor
public enum RequestCodeEnum {

    SUCCESS(0,"成功"),

    FAIL(1,"系统异常"),

    AUTH(401,"您没有权限");


    /**
     * code
     */
    private int code;
    /**
     * 描述
     */
    private String msg;

}
