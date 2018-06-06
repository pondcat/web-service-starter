package com.gj1913894.web.starter.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author gejian at 2018/5/29 23:50
 */
@Table(name = "user")
public class User implements DbEntity<Long> {
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;

	private String mobile;

	private String realName;

	private String stat;

	private LocalDateTime ctime;

	private Long creator;

	@Override
	public Long getId() {
		return id;
	}

	@Override
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

	@Override
	public LocalDateTime getCtime() {
		return ctime;
	}

	@Override
	public void setCtime(LocalDateTime ctime) {
		this.ctime = ctime;
	}

	@Override
	public Long getCreator() {
		return creator;
	}

	@Override
	public void setCreator(Long creator) {
		this.creator = creator;
	}

}
