package com.zkdn.zk.common.core.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* @author zhangchunhao
* @apiNote 返回信息工具类
* @date 19:39 2021/9/14
* @param
* @return
**/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseTransferEntity<T> implements Serializable {

    private int resultCode;

    private String resultMsg;

    private T resultBody;

}
