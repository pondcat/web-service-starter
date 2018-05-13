package com.gj1913894.web.starter.exception;

/**
 * 所有对外(第三方)业务异常父类
 *
 * @author gejian at 2018/5/13 21:12
 */
public class BusinessOutException extends RuntimeException {
	// 异常代码, 一般用不到, 对第三方提供服务时可用, 严禁用于逻辑跳转
	private String code;

	public BusinessOutException() {
	}

	public BusinessOutException(String message) {
		super(message);
	}

	public BusinessOutException(String message, String code) {
		super(message);
		this.code = code;
	}

	public BusinessOutException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessOutException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public BusinessOutException(Throwable cause) {
		super(cause);
	}

	public BusinessOutException(Throwable cause, String code) {
		super(cause);
		this.code = code;
	}

	public BusinessOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
