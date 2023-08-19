package com.pros.pick.domain.user.entity;

import com.pros.pick.domain.user.dto.UserRewardDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String birthday;

	private int accumulatedPointReward;

	private String age;

	private String deviceKey;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private UserLocation userLocation;

	public void updatePointReward(UserRewardDto userRewardDto){

	}
}
