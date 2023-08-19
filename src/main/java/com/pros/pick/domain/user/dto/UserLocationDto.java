package com.pros.pick.domain.user.dto;

import com.pros.pick.domain.user.entity.UserLocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserLocationDto {
	private Double latitude;
	private Double longitude;
	private String address;

	public UserLocationDto() {}

	public UserLocationDto(UserLocation userLocation) {
		this.latitude = userLocation.getLatitude();
		this.longitude = userLocation.getLongitude();
		this.address = userLocation.getAddress();
	}
}
