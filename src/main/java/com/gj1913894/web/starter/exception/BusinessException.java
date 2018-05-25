package com.gj1913894.web.starter.exception;

/**
 * 所有业务异常父类
 * @author gejian
 */
public class BusinessException extends RuntimeException {

	// 异常代码, 一般用不到, 对第三方提供服务时可用, 严禁用于逻辑跳转
	private String code;

	public BusinessException() {
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, String code) {
		super(message);
		this.code = code;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(Throwable cause, String code) {
		super(cause);
		this.code = code;
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}
