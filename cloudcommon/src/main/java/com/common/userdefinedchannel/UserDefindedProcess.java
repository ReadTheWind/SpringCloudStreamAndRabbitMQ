package com.common.userdefinedchannel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author liuhuan
 * 用户自定义通道
 */
public interface UserDefindedProcess {

	public  static final String OUTPUT="user_output";

	public static final String INPUT="user_input";

	@Input(UserDefindedProcess.INPUT)
	public SubscribableChannel input();

	@Output(UserDefindedProcess.OUTPUT)
	public MessageChannel ouput();
}
