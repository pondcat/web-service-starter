package com.gj1913894.web.starter.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author 孙权
 */
public class UserDto {
    private Integer id;
    private String username;
    private String mobile;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
