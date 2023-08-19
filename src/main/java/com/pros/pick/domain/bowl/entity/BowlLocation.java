package com.pros.pick.domain.bowl.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BowlLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bowl_location_id")
	private Long id;

	private Double longitude;

	private Double latitude;

	@OneToOne(fetch = FetchType.LAZY, cascade = ALL)
	@JoinColumn(name = "bowl_id", nullable = false)
	private Bowl bowl;
}
