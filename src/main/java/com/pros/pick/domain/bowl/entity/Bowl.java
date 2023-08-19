package com.pros.pick.domain.bowl.entity;

import com.pros.pick.domain.bowl.entity.vo.CollectState;
import com.pros.pick.domain.bowl.entity.vo.Dish;
import com.pros.pick.domain.shop.entity.Shop;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;


@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class Bowl {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bowl_id")
	private Long id;

	// 다회용 그릇 위치 정보
	@OneToOne(fetch = FetchType.LAZY, cascade = ALL)
	private BowlLocation bowlLocation;

	// 가게 정보
	@ManyToOne
	private Shop shop;

	@ElementCollection
	@CollectionTable(name = "bowl_size_counts", joinColumns = @JoinColumn(name = "bowl_id"))
	@MapKeyColumn(name = "bowl_size")
	@Column(name = "count")
	private Map<String, Integer> bowlCountList = new HashMap<>();

	// 수거 여부 (true: 수거 완료, false: 수거 전)
	private boolean collectionStatus;

	// 수거 상태 WAITING("수거전"), COLLECTING("수거중"), COMPLETE("수거완료")
	@Enumerated(STRING)
	private CollectState collectState;

	// 가게 이름
	private String restaurantName;

	// 가게 주소
	private String restaurantAddress;

	// 현재 미사용
	private String type;

	// 수거 다회용 그룹 무게
	private int weight;

	// 수거 다회용 그룹 사이즈 (SMALL, MEDIUM, LARGE)
	@Enumerated(STRING)
	private Dish dish;

	@Builder
	public Bowl(BowlLocation bowlLocation, Shop shop, Map<String, Integer> bowlCountList, boolean collectionStatus,
	            CollectState collectState, String restaurantName, String restaurantAddress, String type,
	            int weight, Dish dish) {
		this.bowlLocation = bowlLocation;
		this.shop = shop;
		this.bowlCountList = bowlCountList;
		this.collectionStatus = collectionStatus;
		this.collectState = collectState;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.type = type;
		this.weight = weight;
		this.dish = dish;
	}

	public Bowl changeCollectState(CollectState collectState) {
		this.collectState = collectState;
		return this;
	}
}
