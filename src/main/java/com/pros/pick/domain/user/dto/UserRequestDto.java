package com.pros.pick.domain.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserRequestDto {

	private String username;

	private String birthday;

	private Integer age;

	@NotNull
	private String deviceKey;

	private UserLocationDto userLocation;

	private int accumulatedPointReward;

}
