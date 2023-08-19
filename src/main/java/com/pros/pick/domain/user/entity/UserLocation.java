package com.pros.pick.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class UserLocation {

	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long id;

	private Double latitude;

	private Double longitude;

	private String address;

	@Builder
	public UserLocation(String address, Double latitude, Double longitude) {
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
}