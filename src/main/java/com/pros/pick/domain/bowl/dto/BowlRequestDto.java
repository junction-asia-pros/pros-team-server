package com.pros.pick.domain.bowl.dto;

import com.pros.pick.domain.bowl.entity.vo.Dish;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BowlRequestDto {
	private BowlLocationRequestDto location;
	private boolean collectionStatus;
	private String restaurantName;
	private String restaurantAddress;
	private String type;
	private int weight;
	private Dish dish;
}
