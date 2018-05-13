package com.gj1913894.web.starter.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author gejian
 */
public class UserRegisterDto {
	@NotBlank
	private String mobile;

	@NotBlank
	private String code;

	private String username;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserRegisterDto{" +
				"mobile='" + mobile + '\'' +
				", code='" + code + '\'' +
				", username='" + username + '\'' +
				'}';
	}
}
