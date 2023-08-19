package com.pros.pick.domain.bowl.entity.vo;

public enum CollectState {
	WAITING("수거전"),
	COLLECTING("수거중"),
	COMPLETE("수거완료");

	private final String state;

	CollectState(String state) {
		this.state = state;
	}
}
