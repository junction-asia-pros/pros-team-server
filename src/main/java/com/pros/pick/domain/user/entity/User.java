package com.pros.pick.domain.user.entity;

import com.pros.pick.domain.user.dto.UserRewardDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String birthday;

	private Integer age;

//	private int accumulatedPointReward;

	private String deviceKey;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserLocation userLocation;

	@Builder
	public User(Long id, String username, String birthday, Integer age, String deviceKey, UserLocation userLocation) {
		this.id = id;
		this.username = username;
		this.birthday = birthday;
		this.age = age;
//		this.accumulatedPointReward = accumulatedPointReward;
		this.deviceKey = deviceKey;
		this.userLocation = userLocation;
	}

}
