package com.provider.cloudstreamprovider.aop;

import com.provider.cloudstreamprovider.util.AuditLogAnnotation;
import com.provider.cloudstreamprovider.util.AuditLogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandle;

/**
 * 日志服务拦截器
 * @author  liuhuan
 */
@Slf4j
@Component
public class LogHandler extends HandlerInterceptorAdapter {

	@Autowired
	AuditLogUtil auditLogUtil;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		log.info("********--------进入拦截器------********");
		int resultCode=auditLogUtil.sendMsg(request,response,handler,modelAndView);
		if(resultCode != 1){
			log.info("GG,消息推送失败！！！");
		}else{
			log.info("OK!消息推送成功!!!");
		}
	}

}
