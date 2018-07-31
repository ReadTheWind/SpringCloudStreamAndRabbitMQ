package com.comsumer.cloudconsumer.rabbitmq;

import com.common.api.domain.AuditLog;
import com.common.userdefinedchannel.UserDefindedProcess;
import com.comsumer.cloudconsumer.log.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author liuhuan
 */
//@EnableBinding(Sink.class)
@EnableBinding(UserDefindedProcess.class)
@Slf4j
public class ConsumerListener {

	@Autowired
	LogService logService;


//	@StreamListener(Sink.INPUT)
//	public void getMsg(Message<String> message){
//
//		System.out.print("接收到消息*************"+message.getPayload()+"**********");
//		AuditLog auditLog=new AuditLog();
//		auditLog.setIp("192.168.1.1");
//		logService.createLog(auditLog);
//		System.out.print("111111111111111");
//	}

	@StreamListener(UserDefindedProcess.INPUT)
	public void getObjMsg(Message<AuditLog> obj){
		log.info("************------接收到消息-------**********："+obj.getPayload());
		AuditLog auditLog=obj.getPayload();
		logService.createLog(auditLog);
		log.info("******-----消息存入数据库成功。。。。。  ----*****");
	}

}
