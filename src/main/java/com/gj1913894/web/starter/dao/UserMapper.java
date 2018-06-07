package com.gj1913894.web.starter.dao;

import com.gj1913894.web.starter.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

/**
 * @author gejian at 2018/5/29 23:51
 */
public interface UserMapper extends Mapper<User>, InsertListMapper<User> {
}
