package com.pros.pick.domain.bowl.dto;

import com.pros.pick.domain.bowl.entity.vo.Dish;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BowlResponseDto {
	private Long id;
	private Double longitude;
	private Double latitude;
	private String orderAddress1;
	private String orderAddress2;
	private String restaurantName;
	private String restaurantAddress;
	private boolean collectionStatus;
	private String collectorKey; // 사용자 Device Key
	private String type;
	private int weight;
	private Dish dish;
}
