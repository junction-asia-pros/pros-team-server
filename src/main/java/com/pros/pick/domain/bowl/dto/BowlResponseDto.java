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
	private String openAddress1;
	private String openAddress2;
	private String restaurantName;
	private String restaurantAddress;
	private boolean collectionSstatus;
	private String type;
	private int weight;
	private Dish dish;
}
