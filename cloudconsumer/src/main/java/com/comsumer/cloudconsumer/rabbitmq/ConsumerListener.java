package com.comsumer.cloudconsumer.rabbitmq;

import com.common.userdefinedchannel.UserDefindedProcess;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author liuhuan
 */
//@EnableBinding(Sink.class)
@EnableBinding(UserDefindedProcess.class)
public class ConsumerListener {

//	@StreamListener(Sink.INPUT)
	@StreamListener(UserDefindedProcess.INPUT)
	public void getMsg(Message<String> message){
		System.out.print("接收到消息*************"+message.getPayload()+"**********");
		
	}

}
