package com.common.api;

import com.common.api.domain.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author liuhuan
 * 日志dao
 */
public interface AuditLogRep extends JpaRepository<AuditLog,Long> {

}
