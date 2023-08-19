package com.pros.pick.domain.bowl.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BowlLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bowl_location_id")
	private Long id;

	private Double longitude;

	private Double latitude;

	private String orderAddress1;

	private String orderAddress2;

	@Builder
	public BowlLocation(Double longitude, Double latitude, String orderAddress1, String orderAddress2) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.orderAddress1 = orderAddress1;
		this.orderAddress2 = orderAddress2;
	}
}
