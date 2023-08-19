package com.pros.pick.domain.bowl.controller;

import com.pros.pick.domain.bowl.dto.BowlRequestDto;
import com.pros.pick.domain.bowl.dto.BowlResponseDto;
import com.pros.pick.domain.bowl.service.BowlService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bowls")
@RequiredArgsConstructor
@Tag(name = "Bowls", description = "수거용 다회 용기 API")
public class BowlController {

	private final BowlService bowlService;

	@Operation(summary = "수거용 다회 용기 목록 조회")
	@GetMapping()
	public ResponseEntity<List<BowlResponseDto>> getAllBowls() {
		List<BowlResponseDto> response = bowlService.getAllBowls();
		return ResponseEntity.ok(response);
	}

	@Operation(summary = "수거용 다회 용기 등록")
	@PostMapping
	public ResponseEntity<BowlResponseDto> create(@RequestBody BowlRequestDto requestDto) {
		bowlService.create(requestDto);
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "수거용 다회 용기 삭제")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		bowlService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
