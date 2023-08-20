package com.pros.pick.domain.reward.service;

import com.pros.pick.domain.reward.dto.RewardDto;
import com.pros.pick.domain.reward.entity.Reward;
import com.pros.pick.domain.reward.repository.RewardRepository;
import com.pros.pick.domain.user.dto.UserRewardDto;
import com.pros.pick.domain.user.entity.User;
import com.pros.pick.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RewardService {
    private final RewardRepository rewardRepository;

    private final UserRepository userRepository;

    public void checkEligibilityForReward(RewardDto rewardDto) {
        int requiredPoints = 4;
        Optional<User> optionalUser = userRepository.findByUsername(rewardDto.getUserRewardDto().getUsername());
        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("user not found");
        }
        if (rewardDto.getUserRewardDto().getAccumulatedPointReward() == requiredPoints) {

            RewardDto updatedRewardDto = RewardDto.builder()
                    .description("네잎 클로버를 완성했습니다!")
                    .userRewardDto(UserRewardDto.builder()
                            .username(optionalUser.get().getUsername())
                            .accumulatedPointReward(0)
                            .build())
                    .build();
//            rewardRepository.save(Reward.toEntity(updatedRewardDto));
        }
    }

    public void increaseRewardPoint(RewardDto rewardDto) {
        User user = getUserByUsername(rewardDto.getUserRewardDto().getUsername());
        RewardDto updatedRewardDto = RewardDto.builder()
                .description(rewardDto.getDescription())
                .userRewardDto(UserRewardDto.builder()
                        .username(user.getUsername())
                        .accumulatedPointReward(rewardDto.getUserRewardDto().getAccumulatedPointReward() + 1)
                        .build())
                .build();
//        rewardRepository.save(Reward.toEntity(updatedRewardDto));
    }

    public User getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("User not found for username: " + username);
        }
        return optionalUser.get();
    }

}
