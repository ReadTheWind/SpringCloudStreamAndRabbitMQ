package com.provider.cloudstreamprovider.config;

import com.provider.cloudstreamprovider.aop.LogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web配置
 * @author  liuhuan
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	@Autowired
	LogHandler logHandler;

	/**
	 * 添加请求拦截器
	 *
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(logHandler).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
