package com.pros.pick.domain.bowl.entity;

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

	@OneToOne(fetch = FetchType.LAZY, cascade = ALL)
	private BowlLocation bowlLocation;

	@ManyToOne
	private Shop shop;

//	@Enumerated(STRING)
//	private Category category;

	@ElementCollection
	@CollectionTable(name = "bowl_size_counts", joinColumns = @JoinColumn(name = "bowl_id"))
	@MapKeyColumn(name = "bowl_size")
	@Column(name = "count")
	private Map<String, Integer> bowlCountList = new HashMap<>();

	private boolean collectionStatus;

	private String restaurantName;

	private String restaurantAddress;

	private String type;

	private int weight;

	@Enumerated(STRING)
	private Dish dish;

	@Builder
	public Bowl(BowlLocation bowlLocation, boolean collectionStatus, String restaurantName, String restaurantAddress, String type, int weight, Dish dish) {
		this.bowlLocation = bowlLocation;
		this.collectionStatus = collectionStatus;
		this.restaurantName = restaurantName;
		this.restaurantAddress = restaurantAddress;
		this.type = type;
		this.weight = weight;
		this.dish = dish;
	}

	public Bowl changeCollectionStatus(boolean collectionStatus) {
		this.collectionStatus = collectionStatus;
		return this;
	}
}
