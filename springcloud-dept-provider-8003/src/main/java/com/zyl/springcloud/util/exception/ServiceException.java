package com.zyl.springcloud.util.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description: Service 层统一异常 
 */
@Slf4j
@Data
@EqualsAndHashCode(callSuper=false)
public class ServiceException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String msg;
	
	public ServiceException(String msg) {
		this.msg = msg;
	}

	public ServiceException(String code, String errMsg) {
		this.code = code;
		this.msg = errMsg;
	}

}
