package com.pros.pick.domain.bowl.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BowlLocationRequestDto {
	private Double latitude;
	private Double longitude;
	private String orderAddress1;
	private String orderAddress2;
}
