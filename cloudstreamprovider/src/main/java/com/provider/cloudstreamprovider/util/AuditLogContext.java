package com.provider.cloudstreamprovider.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * 日志信息公用信息
 * @author liuhuan
 */
@Component
@Data
public class AuditLogContext {

	/**
	 * 应用名称
	 */
	@Value("${spring.application.name}")
	String applicationName;

	/**
	 * 应用code
	 */
	@Value("${spring.application.index}")
	String applicationCode;



	/**
	 * 操作时间
	 */
	Date operationTime;

	/**
	 * 时间为当前时间
	 * @return
	 */
	public Date getOperationTime() {
		return new Date();
	}

	/**
	 * ip长度
	 */
	private  final  int ipLen=15;

	/**
	 * 获取ip的工具类
	 * @return
	 */
	public String getIpAddress(HttpServletRequest request){
		String ipAddress=null;
		try {
			ipAddress=request.getHeader("x-forward-for");
			if(ipAddress == "" || ipAddress.length() ==0 || "unknown".equalsIgnoreCase(ipAddress)){
				ipAddress=request.getHeader("Proxy-Client-IP");
			}
			if(ipAddress == "" || ipAddress.length() ==0 || "unknown".equalsIgnoreCase(ipAddress) ){
				ipAddress=request.getHeader("WL-Proxy--Client-IP");
			}
			if(ipAddress == "" || ipAddress.length() ==0 || "unknown".equalsIgnoreCase(ipAddress)){
				ipAddress=request.getRemoteAddr();
				if(ipAddress.equals("127.0.0.1")){
					//根据网卡取本机Ip地址
					InetAddress inet=null;
					try{
						inet= InetAddress.getLocalHost();
					}catch (UnknownHostException e){
						e.printStackTrace();
					}
					ipAddress=inet.getHostAddress();
				}
			}
			//对于通过多个代理的情况，第一个IP为客户端真实的IP,多个IP按照“，”分隔
			// "***.***.***.***".length()
			if(ipAddress != null && ipAddress.length()>ipLen){
				if(ipAddress.indexOf(",") > 0){
					ipAddress=ipAddress.substring(0,ipAddress.indexOf(","));
				}
			}
		}catch (Exception e){
			ipAddress="";
		}
		return ipAddress;
	}

	public CasUser getUser(){
		CasUser casUser= new CasUser();
		casUser.setUserName("liuhuan");
		casUser.setUserCode("A001");
		casUser.setOrgCode("ORG0000008");
		casUser.setEntId(8);
		return casUser;
	}

}
