package com.provider.cloudstreamprovider.aop;

import com.provider.cloudstreamprovider.util.CasUser;
import com.provider.cloudstreamprovider.util.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 自定义参数解析器
 * @author liuhuan
 * 增加方法注入，将含有CurrentUser注解的方法参数注入当前登录用户
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver{

	/**
	 * 用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument
	 * @param methodParameter
	 * @return
	 */
	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		// 如果参数类型是User并且有CurrentUser注解则支持
		return methodParameter.getParameterType().isAssignableFrom(CasUser.class)
				&& methodParameter.hasParameterAnnotation(CurrentUser.class);
	}

	/**
	 * 真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象
	 * @param methodParameter
	 * @param modelAndViewContainer
	 * @param nativeWebRequest
	 * @param webDataBinderFactory
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
		//这可写从单点登录系统获取用户信息的逻辑
		CasUser casUser = new CasUser();
		casUser.setUserName("liuhuan");
		casUser.setUserCode("A001");
		casUser.setOrgCode("ORG0000008");
		casUser.setEntId(8);
		return casUser;
	}
}
