package com.gj1913894.web.starter.dto;

import com.gj1913894.web.starter.entity.User;

/**
 * @author 孙权
 */
public class Student extends User {
	private String grade;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}
