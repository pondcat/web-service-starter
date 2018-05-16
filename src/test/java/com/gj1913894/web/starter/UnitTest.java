package com.gj1913894.web.starter;

import com.alibaba.fastjson.JSON;
import com.gj1913894.web.starter.dto.Result;
import com.gj1913894.web.starter.entity.User;
import org.junit.Test;

import java.lang.reflect.Type;

/**
 * @author gejian
 */
public class UnitTest {

    @Test
    public void tt() {
		Result<User> data = new Result<User>();
		data.setCode("sd");
		data.setMsg("hh");
		User user = new User();
		user.setId(33L);
		user.setMobile("16621005051");
		data.setT(user);
		String s = JSON.toJSONString(data);
		Result o = JSON.parseObject(s, (Type) data.getClass().getComponentType());
		Object t = o.getT();
		System.out.println(t.getClass());
    }

}
