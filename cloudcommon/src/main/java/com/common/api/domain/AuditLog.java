package com.common.api.domain;

import com.common.api.EntityListener;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liuhuan
 * 日志实体
 */
@Data
@Entity
@Table(name = "audit_log")
@EntityListeners(EntityListener.class)
public class AuditLog implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "application_code")
	private String applicationCode;

	@Column(name = "application_name")
	private  String applicationName;

	@Column(name = "module_code")
	private String moduleCode;

	@Column(name = "moduleName")
	private  String moduleName;

	@Column(name = "page_code")
	private  String pageCode;

	@Column(name = "page_name")
	private  String pageName;

	@Column(name = "operation_func")
	private String  operationFunc;

	@Column(name = "operation_note")
	private  String operationNote;

	@Column(name = "httpMethod")
	private String httpMethod;

	@Column(name = "operation_args")
	private  String operationArgs;

	@Column(name = "operator_code")
	private String operatorCode;

	@Column(name = "operator_name")
	private  String operatorName;

	@Column(name = "operation_time")
	private Date operationTime;

	@Column(name = "ip")
	private  String ip;

	@Column(name = "operator_org_code")
	private  String operatorOrgCode;

	@Column(name = "operation_result")
	private  String operationResult;

	@Column(name = "extension")
	private String extension;

	@Column(name = "deleted")
	private  Long deleted;

}
