package com.gj1913894.web.starter.api;

import com.gj1913894.web.starter.entity.User;
import com.gj1913894.web.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pondcat.commons.combine.Result;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author gejian
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {
	private @Autowired DemoService demoService;

	@GetMapping("ss")
	public Result<String> demo() {
		return Result.ok(LocalDateTime.now().toString());
	}

	@GetMapping("{id}/ss")
	public Result<String> demo1(@PathVariable Integer id) {
		return Result.ok(LocalDateTime.now().toString());
	}

	@GetMapping("serve")
	public Result<String> serve(User user) {
		System.out.println(user);
		LocalDateTime dateTime = demoService.serve();
		return Result.ok(dateTime.toString());
	}

	@PostMapping(value = "tt", params = {"id=1"})
	public void t1(@RequestBody User user) {
		System.out.println(user.getId());
	}

	@RequestMapping("tt")
	public User t2(User user) {
		user.setCtime(LocalDateTime.now());
		user.setMtime(new Date());
		user.setNow(Instant.now());
		return user;
	}
}
