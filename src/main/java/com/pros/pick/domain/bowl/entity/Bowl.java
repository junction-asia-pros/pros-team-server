package com.pros.pick.domain.bowl.entity;

import com.pros.pick.domain.bowl.entity.vo.BowlWeight;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.CascadeType.ALL;
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

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "bowl", cascade = ALL)
	private BowlLocation bowlLocation;

	private boolean collectionStatus;

	private String type;

	@Enumerated(EnumType.STRING)
	private BowlWeight weight;
}
