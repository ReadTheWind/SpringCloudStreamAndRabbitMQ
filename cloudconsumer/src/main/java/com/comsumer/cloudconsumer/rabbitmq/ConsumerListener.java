package com.comsumer.cloudconsumer.rabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author liuhuan
 */
@EnableBinding(Sink.class)
public class ConsumerListener {

	@StreamListener(Sink.INPUT)
	public void getMsg(Message<String> message){
		System.out.print("接收到消息*************"+message.getPayload()+"**********");
		
	}

}
