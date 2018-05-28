package com.gj1913894.web.starter;

import com.alibaba.fastjson.JSON;
import com.gj1913894.web.starter.dto.KeyValue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gejian
 */
public class UnitTest {

	@Test
	public void tt() {
		/*Map<Integer, String> map = new HashMap<>();
		map.put(-1, "");
		map.put(0, "只做租赁");
		map.put(1, "只做售房");
		map.put(2, "租赁为主");
		map.put(3, "售房为主");
		map.put(4, "租售各半");
		System.out.println(JSON.toJSONString(map));
		map.clear();
		map.put(-1, "");
		map.put(0, "公司付费");
		map.put(1, "个人付费");
		map.put(2, "公司个人对半");
		System.out.println(JSON.toJSONString(map));
		map.clear();
		map.put(-1, "");
		map.put(0, "58");
		map.put(1, "安居客");
		map.put(2, "搜房网");
		map.put(3, "百姓网");
		map.put(4, "其他");
		System.out.println(JSON.toJSONString(map));
		Pair<String, String> of = Pair.of("a", "b");
		System.out.println(JSON.toJSONString(of));*/
		/*List<KeyValue> keyValues = new ArrayList<>();
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			KeyValue<Integer, String> keyValue1 = KeyValue.of(entry.getKey(), entry.getValue());
			keyValues.add(keyValue1);
		}*/
		KeyValue<Integer, String> ss = KeyValue.of(1, "lily");
		KeyValue<Integer, String> ss1 = KeyValue.of(2, "lucy");
		List<KeyValue> keyValues = new ArrayList<>();
		keyValues.add(ss);
		keyValues.add(ss1);
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "lily");
		map.put(2, "lucy");
		String s = JSON.toJSONString(map);
		System.out.println(s);
		KeyValue keyValue = JSON.parseObject(s, KeyValue.MutableKeyValue.class);
		System.out.println(keyValue);
	}

}
