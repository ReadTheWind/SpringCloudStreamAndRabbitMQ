package com.provider.cloudstreamprovider.rabbtimq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author liuhuan
 */
@EnableBinding(Source.class)
public class ProviderMessageImpl implements  IMessageService {

	@Resource
	MessageChannel output;//只能是output

	@Override
	public void send(String msg) {
		this.output.send(MessageBuilder.withPayload(msg).build());
	}
}
