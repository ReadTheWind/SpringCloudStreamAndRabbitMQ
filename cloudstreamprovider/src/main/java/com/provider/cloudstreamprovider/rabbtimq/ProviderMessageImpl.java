package com.provider.cloudstreamprovider.rabbtimq;

import com.common.api.domain.AuditLog;
import com.common.userdefinedchannel.UserDefindedProcess;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author liuhuan
 */
//@EnableBinding(Source.class)
@EnableBinding(UserDefindedProcess.class)
public class ProviderMessageImpl implements  IMessageService {

	/**
	 * 消息发送的管道
	 * 默认通道名称只能是output
	 */
//	@Resource
//	MessageChannel output;

	/**
	 * 自定义通过名为
	 */
	@Resource
	MessageChannel user_output;

	@Override
	public void send(String msg) {
//		this.output.send(MessageBuilder.withPayload(msg).build());
	}

	@Override
	public void sendObj(AuditLog msg) {
		this.user_output.send(MessageBuilder.withPayload(msg).build());
	}
}
