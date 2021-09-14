package com.zkdn.zk.common.core.util;

/**
 * 正则表达式工具类
 * @author Brain
 */
public class RegexUtil {

    /**
     * 返回根据Json的key获得value的正则表达式
     * 该表达式匹配如：{"password":"123456"}，则返回123456
     * @param jsonKey
     * @return java.lang.String
     */
    public static String getJSonValueRegex(String jsonKey){
        return "(?<=\""+ jsonKey +"\":\")[^\",]*";
    }
    /**
     * 返回根据Json的key获得Json的"key:value"的正则表达式
     * 该表达式匹配如：{"password":"123456"}，则返回"password":"123456"
     * @param jsonKey
     * @return java.lang.String
     */
    public static String getJSonRegex(String jsonKey){
        return "\""+ jsonKey +"\":\"([^\"]+)\"";
    }


}
