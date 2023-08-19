package com.pros.pick.domain.bowl.entity.vo;

public enum Dish {
	SMALL("1"),
	MEDIUM("3"),
	LARGE("5");

	private final String weight;

	Dish(String weight) {
		this.weight = weight;
	}
}
