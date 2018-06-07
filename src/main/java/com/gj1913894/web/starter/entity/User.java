package com.gj1913894.web.starter.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author gejian at 2018/5/29 23:50
 */
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;

	private String mobile;

	private String realName;

	private String stat;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime ctime;

	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date mtime;

	private Long creator;

	private Instant now;

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

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	public Instant getNow() {
		return now;
	}

	public void setNow(Instant now) {
		this.now = now;
	}
}
