package com.provider.cloudstreamprovider.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解
 * @author liuhuan
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuditLogAnnotation {

	/**
	 * '模块Code'
	 * @return
	 */
	String moduleCode() default "";

	/**
	 * '模块名称'
	 * @return
	 */
	String moduleName() default "";

	/**
	 * '操作页面名称
	 * @return
	 */
	String pageName() default "";

	/**
	 * '操作页面Code'
	 * @return
	 */
	String pageCode() default "";

	/**
	 * '操作功能'
	 * @return
	 */
	String operationFunction() default "";

	/**
	 * '操作参数'
	 * @return
	 */
	String operationArgs() default "";


	/**
	 * '扩展字段'
	 * @return
	 */
	String extension() default  "";
}
