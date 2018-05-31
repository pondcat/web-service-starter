package com.gj1913894.web.starter.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

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

	private LocalDateTime ctime;

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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", mobile='" + mobile + '\'' +
				", realName='" + realName + '\'' +
				", stat='" + stat + '\'' +
				", ctime=" + ctime +
				'}';
	}
}