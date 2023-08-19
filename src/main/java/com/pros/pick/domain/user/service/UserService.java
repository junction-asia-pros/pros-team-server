package com.pros.pick.domain.user.service;

import com.pros.pick.domain.user.dto.UserRequestDto;
import com.pros.pick.domain.user.dto.UserResponseDto;
import com.pros.pick.domain.user.entity.User;
import com.pros.pick.domain.user.entity.UserLocation;
import com.pros.pick.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional(readOnly = true)
	public UserResponseDto getUser(String deviceKey) {
		User findUser = userRepository.findByDeviceKey(deviceKey)
				.orElseThrow(() -> new IllegalArgumentException("Not Found User deviceKey=" + deviceKey));

		return new UserResponseDto(findUser);
	}

	@Transactional
	public UserResponseDto create(UserRequestDto requestDto) {

		UserLocation userLocation = UserLocation.builder()
				.latitude(requestDto.getUserLocation().getLatitude())
				.longitude(requestDto.getUserLocation().getLongitude())
				.build();

		User user = User.builder()
				.username(requestDto.getUsername())
				.userLocation(userLocation)
				.age(requestDto.getAge())
				.birthday(requestDto.getBirthday())
				.deviceKey(requestDto.getDeviceKey())
				.build();

		userRepository.save(user);

		return new UserResponseDto(user);
	}
}
