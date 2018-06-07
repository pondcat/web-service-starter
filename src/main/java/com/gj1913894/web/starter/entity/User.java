package com.gj1913894.web.starter.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author gejian at 2018/5/29 23:50
 */
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;

	@NotNull
	private String mobile;

	private String realName;

	private String stat;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime ctime;

	private String role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public LocalDateTime getCtime() {
		return ctime;
	}

	public void setCtime(LocalDateTime ctime) {
		this.ctime = ctime;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
