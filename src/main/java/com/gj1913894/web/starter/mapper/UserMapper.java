package com.gj1913894.web.starter.mapper;

import com.gj1913894.web.starter.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	@Select("select * from user where id = #{id}")
	User selectByPrimaryKey(Long id);

	@Select("select * from user where mobile = #{mobile}")
	long countByMobile(String mobile);

	default boolean existsByMobile(String mobile) {
		return countByMobile(mobile) > 0L;
	}

	void insert(User user);
}
