package com.pros.pick.domain.user.controller;

//import com.pros.pick.domain.user.service.UserService;
import com.pros.pick.domain.user.dto.UserRequestDto;
import com.pros.pick.domain.user.dto.UserResponseDto;
import com.pros.pick.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final UserService userService;

	@GetMapping("/me/{deviceUuid}")
	public ResponseEntity<UserResponseDto> getUser(@PathVariable String deviceUuid) {
		return ResponseEntity.ok(userService.getUser(deviceUuid));
	}

	@PostMapping("/me")
	public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
		userService.create(requestDto);
		return ResponseEntity.ok().build();
	}
}
