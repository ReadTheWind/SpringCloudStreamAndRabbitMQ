package com.provider.cloudstreamprovider.controller;

import com.provider.cloudstreamprovider.util.AuditLogAnnotation;
import com.provider.cloudstreamprovider.util.CasUser;
import com.provider.cloudstreamprovider.util.CurrentUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhuan
 * 模拟日志controler
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

	@GetMapping(value = "get")
	@AuditLogAnnotation(pageName = "测试页面",pageCode = "p01",moduleName = "stock",moduleCode = "s01",operationFunction = "测试审计日志",operationArgs = "id")
	public void  testStream(@CurrentUser CasUser casUser){
		log.info("*******-----进入controller----***********");
	}
}
