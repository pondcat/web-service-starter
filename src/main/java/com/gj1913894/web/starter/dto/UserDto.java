package com.gj1913894.web.starter.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * @author 孙权
 */
@Data
public class UserDto {
    private Integer id;
    private String username;
    private String mobile;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
