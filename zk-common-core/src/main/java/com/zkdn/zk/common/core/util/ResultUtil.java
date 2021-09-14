package com.zkdn.zk.common.core.util;

import com.zkdn.zk.common.core.constant.enums.RequestCodeEnum;
import com.zkdn.zk.common.core.web.model.BaseTransferEntity;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
* @author zhangchunhao
* @apiNote 返回信息工具类
* @date 19:40 2021/9/14
* @param
* @return
**/
public class ResultUtil {
    public static <T> BaseTransferEntity<T> newSuccessBaseTransferEntity() {
        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setResultCode(200);
        baseTransferEntity.setResultMsg("SUCCESS");
        return baseTransferEntity;
    }

    public static <T> BaseTransferEntity<T> newBaseTransferEntity(Boolean isSuccess, T message) {
        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        if (Boolean.TRUE.equals(isSuccess)) {
            baseTransferEntity.setResultCode(200);
            baseTransferEntity.setResultBody(message);
        }
        else {
            baseTransferEntity.setResultCode(400);
            baseTransferEntity.setResultMsg(message + "");
        }

        return baseTransferEntity;
    }

    public static <T> BaseTransferEntity newBaseTransferEntity(List<T> messages, Long total) {
        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setResultBody(messages);
        baseTransferEntity.setResultCode(200);
        return baseTransferEntity;
    }

    /**
     * @return com.musee.hb.common.core.web.model.BaseTransferEntity
     * @Author Liyo
     * @Description 简单封装返回值对象
     * @Date 16:04 2019/4/19
     * @Modificd By:
     * @Param [codeEnum, msg, t]
     **/
    public static <T> BaseTransferEntity resultModel(RequestCodeEnum codeEnum, String msg, T t) {

        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setResultBody(t);
        int code = (RequestCodeEnum.SUCCESS).equals(codeEnum) ? 200 : 400;
        baseTransferEntity.setResultCode(code);

        if (StringUtils.isEmpty(msg)) {
            msg = code == 200 ? "执行成功！" : "执行失败！";
        }

        baseTransferEntity.setResultMsg(msg);
        return baseTransferEntity;
    }
}