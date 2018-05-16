package com.gj1913894.web.starter.dto;

/**
 * @author 孙权
 */
public class Result<T> {
	private String code;

	private String msg;

	private T t;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
