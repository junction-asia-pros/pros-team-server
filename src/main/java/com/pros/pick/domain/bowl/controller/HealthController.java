package com.pros.pick.domain.bowl.controller;

import com.pros.pick.domain.bowl.entity.Bowl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {
	@GetMapping({"/health", "/"})
	public String health() {
		return "OK";
	}

}
