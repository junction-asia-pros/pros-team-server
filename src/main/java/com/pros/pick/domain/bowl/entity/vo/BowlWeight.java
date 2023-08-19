package com.pros.pick.domain.bowl.entity.vo;

public enum BowlWeight {
	SMALL("1"),
	MEDIUM("3"),
	LARGE("5");

	private final String weight;

	BowlWeight(String weight) {
		this.weight = weight;
	}
}
