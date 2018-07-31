package com.provider.cloudstreamprovider.controller;

import com.provider.cloudstreamprovider.util.AuditLogAnnotation;
import com.provider.cloudstreamprovider.util.CasUser;
import com.provider.cloudstreamprovider.util.CurrentUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhuan
 * 模拟日志controler
 */
@RestController
@RequestMapping("/log")
public class LogController {

	@GetMapping(value = "get")
	@AuditLogAnnotation(pageName = "测试页面",pageCode = "p01",moduleName = "stock",moduleCode = "s01",operationFunction = "测试审计日志",operationArgs = "id")
	public void  testStream(@CurrentUser CasUser casUser){
		System.out.println("进入controller");
	}
}
