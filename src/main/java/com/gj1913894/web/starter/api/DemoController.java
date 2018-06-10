package com.gj1913894.web.starter.api;

import com.gj1913894.web.starter.entity.User;
import com.gj1913894.web.starter.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pondcat.commons.combine.Result;

import javax.validation.Valid;
import java.time.LocalDateTime;

/**
 * @author gejian
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {

	private static final Logger log = LoggerFactory.getLogger(DemoController.class);

	private @Autowired DemoService demoService;

	@GetMapping("ss")
	public Result<String> demo() {
		return Result.ok(LocalDateTime.now().toString());
	}

	@GetMapping("{id}/ss")
	public Result<String> demo1(@PathVariable Integer id) {
		return Result.ok(LocalDateTime.now().toString());
	}

	@PostMapping("serve")
	public Result<String> serve(@Valid User user) {
		log.debug(user.toString());
		LocalDateTime dateTime = demoService.serve(user);
		return Result.ok(dateTime.toString());
	}

	@PostMapping(value = "tt", params = { "id=1" })
	public void t1(@RequestBody User user) {
		log.debug(user.toString());
	}

	@RequestMapping("tt")
	public User t2(@RequestBody User user) {
		user.setCtime(LocalDateTime.now());
		return user;
	}

}
