package com.gj1913894.web.starter.ctrl;

import com.gj1913894.web.starter.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@RestController
public class CategoryController {
	@RequestMapping(value = "/category/Resource", method = RequestMethod.GET)
	public ResponseEntity<String> search(@RequestParam(value = "someEnum") User someEnum) {
		return ResponseEntity.ok(someEnum.toString());
	}

	@RequestMapping(value = "/category/map", method = RequestMethod.GET)
	public Map<String, Map<String, String>> map() {
		return newHashMap();
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> someOperation(@PathVariable long id, @RequestBody int userId) {
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "/category/{id}/{userId}", method = RequestMethod.POST)
	public ResponseEntity<Void> ignoredParam(@PathVariable long id, @PathVariable @ApiIgnore int userId) {
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "/category/{id}/map", method = RequestMethod.POST)
	public ResponseEntity<Void> map(@PathVariable String id, @RequestParam Map<String, String> test) {
		return ResponseEntity.ok(null);
	}

	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public ResponseEntity<List<User>> map(String[] categories) {
		return ResponseEntity.ok(null);
	}
}
