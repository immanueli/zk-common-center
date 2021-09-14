package com.zkdn.zk.common.core.exception;

import lombok.Data;

/**
* @author zhangchunhao
* @apiNote 业务异常
* @date 19:32 2021/9/14
* @param
* @return
**/
@Data
public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException(int code, String msg){
        super(msg);
        this.code = code;
    }


}
