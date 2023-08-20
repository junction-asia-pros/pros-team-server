package com.pros.pick.domain.reward.controller;

import com.pros.pick.domain.reward.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reward")
public class RewardController {

    private final RewardService rewardService;




}
