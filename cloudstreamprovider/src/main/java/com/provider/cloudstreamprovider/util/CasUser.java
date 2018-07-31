package com.provider.cloudstreamprovider.util;

import lombok.Data;

/**
 * 模拟从单点登录系统获取的用户信息
 * @author liuhuan
 */
@Data
public class CasUser {

	/**
	 *用户名
	 */
	private  String userName;

	/**
	 * 用户code
	 */
	private  String userCode;

	/**
	 * 用户部门code
	 */
	private String orgCode;

	/**
	 * 企业ID
	 */
	private int entId;
}
