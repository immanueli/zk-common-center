package com.zkdn.zk.common.core.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* @author zhangchunhao
* @apiNote 登录类型
* @date 19:31 2021/9/14
* @param
* @return
**/
@Getter
@AllArgsConstructor
public enum LoginTypeEnum {
	/**
	 * 账号密码登录
	 */
	PWD("PWD", "账号密码登录"),

	/**
	 * 验证码登录
	 */
	SMS("SMS", "验证码登录");


	/**
	 * 类型
	 */
	private String type;
	/**
	 * 描述
	 */
	private String description;
}
