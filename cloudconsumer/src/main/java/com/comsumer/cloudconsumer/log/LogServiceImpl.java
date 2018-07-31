package com.comsumer.cloudconsumer.log;

import com.common.api.domain.AuditLog;
import com.common.api.AuditLogRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuhuan
 * 日志接口实现类
 */
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	AuditLogRep auditLogRep;

	@Override
	public AuditLog createLog(AuditLog auditLog) {
		return auditLogRep.save(auditLog);
	}
}
