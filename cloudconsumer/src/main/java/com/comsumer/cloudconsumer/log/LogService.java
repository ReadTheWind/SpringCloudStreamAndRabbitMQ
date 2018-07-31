package com.comsumer.cloudconsumer.log;

import com.common.api.domain.AuditLog;

/**
 * @author liuhuan
 * 日志service
 */
public interface LogService {

	/**
	 * 日志创建接口
	 * @param auditLog
	 * @return
	 */
	public AuditLog createLog(AuditLog auditLog);
}
