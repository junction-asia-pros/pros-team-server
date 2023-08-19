package com.pros.pick.domain.user.dto;

import com.pros.pick.domain.user.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
	private Long id;
	private String username;
	private String birthday;
	private int age;
	private String deviceKey;
	private UserLocationDto userLocationDto;

	public UserResponseDto(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.birthday = user.getBirthday();
		this.age = user.getAge();
		this.deviceKey = user.getDeviceKey();
		this.userLocationDto = new UserLocationDto(user.getUserLocation());
	}
}
