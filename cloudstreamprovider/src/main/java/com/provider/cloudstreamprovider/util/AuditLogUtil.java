package com.provider.cloudstreamprovider.util;

import com.common.api.domain.AuditLog;
import com.provider.cloudstreamprovider.rabbtimq.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志服务逻辑处理类
 * @author liuhuan
 */
@Component
public class AuditLogUtil {

	@Autowired
	IMessageService messageService;

	@Autowired
	AuditLogContext auditLogContext;

	/**
	 * 发送mq信息
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @return
	 */
	public  int sendMsg(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView){
		System.out.println("*************------进入方法sendMsg,准备向MQ推送消息---*************");
		HandlerMethod method=(HandlerMethod)handler;
		AuditLogAnnotation auditLogAnnotation=method.getMethodAnnotation(AuditLogAnnotation.class);
		AuditLog auditLog = new AuditLog();
		//获取项目公共信息
		auditLog.setIp(auditLogContext.getIpAddress(request));
		auditLog.setApplicationCode(auditLogContext.getApplicationCode());
		auditLog.setApplicationName(auditLogContext.getApplicationName());
		auditLog.setOperationTime(auditLogContext.getOperationTime());
		//获取用户信息
//		CasUser casUser=auditLogContext.getUser();
//		auditLog.setOperatorCode(casUser.getUserCode());
//		auditLog.setOperatorName(casUser.getUserName());
//		auditLog.setOperatorOrgCode(casUser.getOrgCode());
		//从swagger注解中获取部分信息
//		auditLog.setOperationFunc(apiOperation.value());
//		auditLog.setHttpMethod(apiOperation.httpMethod());
//		auditLog.setOperationResult(apiOperation.code()+"");
//		auditLog.setOperationNote(apiOperation.notes());
		//从自定义注解中获取信息
		auditLog.setModuleName(auditLogAnnotation.moduleName());
		auditLog.setModuleCode(auditLogAnnotation.moduleCode());
		auditLog.setOperationArgs(auditLogAnnotation.operationArgs());
		auditLog.setExtension(auditLogAnnotation.extension());
		auditLog.setPageName(auditLogAnnotation.pageName());
		auditLog.setPageCode(auditLogAnnotation.pageCode());
		System.out.println("*************---开始推送消息--*************");
		try {
			messageService.sendObj(auditLog);
		}catch (Exception e){
			return 0;
		}
		return 1;
	}
}
