package com.provider.cloudstreamprovider.rabbtimq;

import com.common.api.domain.AuditLog;

/**
 * @author liuhuan
 */
public interface IMessageService {

	/**
	 * 消息发送接口
	 * @param msg
	 */
	public void send(String msg);

	/**
	 * 发送日志信息接口
	 * @param msg
	 */
	public void sendObj(AuditLog msg);
}
