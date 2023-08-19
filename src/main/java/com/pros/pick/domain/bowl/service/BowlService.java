package com.pros.pick.domain.bowl.service;

import com.pros.pick.domain.bowl.dto.BowlRequestDto;
import com.pros.pick.domain.bowl.dto.BowlResponseDto;
import com.pros.pick.domain.bowl.entity.Bowl;
import com.pros.pick.domain.bowl.entity.BowlLocation;
import com.pros.pick.domain.bowl.repository.BowlRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BowlService {

	private final BowlRepository bowlRepository;

	@Transactional(readOnly = true)
	public List<BowlResponseDto> getAllBowls() {
		List<Bowl> bowls = bowlRepository.findAll();
		return bowls.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}

	private BowlResponseDto convertToDto(Bowl bowl) {
		BowlResponseDto dto = new BowlResponseDto();
		dto.setId(bowl.getId());
		dto.setRestaurantName(bowl.getRestaurantName());
		dto.setRestaurantAddress(bowl.getRestaurantAddress());
		dto.setCollectionStatus(bowl.isCollectionStatus());
		dto.setType(bowl.getType());
		dto.setWeight(bowl.getWeight());
		dto.setDish(bowl.getDish());

		if (bowl.getBowlLocation() != null) {
			dto.setLatitude(bowl.getBowlLocation().getLatitude());
			dto.setLongitude(bowl.getBowlLocation().getLongitude());
			dto.setOrderAddress1(bowl.getBowlLocation().getOrderAddress1());
			dto.setOrderAddress2(bowl.getBowlLocation().getOrderAddress2());
		}
		return dto;
	}

	@Transactional(readOnly = true)
	public BowlResponseDto getBowl(Long id) {
		Bowl bowl = bowlRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Bowl not found with id: " + id));
		return convertToDto(bowl);
	}

	@Transactional
	public void create(BowlRequestDto requestDto) {
		BowlLocation bowlLocation = BowlLocation.builder()
				.latitude(requestDto.getLocation().getLatitude())
				.longitude(requestDto.getLocation().getLongitude())
				.orderAddress1(requestDto.getLocation().getOrderAddress1())
				.orderAddress2(requestDto.getLocation().getOrderAddress2())
				.build();

		Bowl bowl = Bowl.builder()
				.bowlLocation(bowlLocation)
				.collectionStatus(requestDto.isCollectionStatus())
				.restaurantName(requestDto.getRestaurantName())
				.restaurantAddress(requestDto.getRestaurantAddress())
				.type(requestDto.getType())
				.weight(requestDto.getWeight())
				.dish(requestDto.getDish())
				.build();

		bowlRepository.save(bowl);
	}

	@Transactional
	public BowlResponseDto update(Long id) {
		Bowl bowl = bowlRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Bowl not found with id: " + id));
		Bowl changedBowl = bowl.changeCollectionStatus(true);
		return convertToDto(changedBowl);
	}

	@Transactional
	public void delete(Long id) {
		Bowl bowl = bowlRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Bowl not found with id: " + id));
		bowlRepository.delete(bowl);
	}
}
