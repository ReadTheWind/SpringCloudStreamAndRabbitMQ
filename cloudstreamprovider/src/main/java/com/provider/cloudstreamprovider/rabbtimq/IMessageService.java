package com.provider.cloudstreamprovider.rabbtimq;

/**
 * @author liuhuan
 */
public interface IMessageService {

	/**
	 * 消息发送接口
	 * @param msg
	 */
	public void send(String msg);
}
