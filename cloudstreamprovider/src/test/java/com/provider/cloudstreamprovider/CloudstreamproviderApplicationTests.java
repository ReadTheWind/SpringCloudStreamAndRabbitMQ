package com.provider.cloudstreamprovider;

import com.common.api.domain.AuditLog;
import com.provider.cloudstreamprovider.rabbtimq.IMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudstreamproviderApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	IMessageService messageService;

	/**
	 * 测试消息发送
	 */
	@Test
	public void sendmsg() {
		messageService.send("Hello Word!!!");
	}

	/**
	 * 测试消息发送obj
	 */
	@Test
	public void sendObjmsg() {
		AuditLog auditLog=new AuditLog();
		auditLog.setApplicationCode("应用code");
		auditLog.setApplicationName("应用名称");
		auditLog.setIp("127.0.0.8");
		auditLog.setHttpMethod("GET");
		auditLog.setModuleName("模型名");
		auditLog.setModuleCode("模型code");
		auditLog.setOperationArgs("操作参数");
		auditLog.setOperationFunc("操作功能");
		auditLog.setOperationNote("操作信息");
		auditLog.setOperatorName("操作人");
		auditLog.setOperatorCode("操作人code");
		auditLog.setOperatorOrgCode("ORG01");
		auditLog.setPageName("页面名");
		auditLog.setPageCode("页面code");
		auditLog.setOperationTime(new Date());
		auditLog.setOperationResult("200");

		messageService.sendObj(auditLog);
	}

}
