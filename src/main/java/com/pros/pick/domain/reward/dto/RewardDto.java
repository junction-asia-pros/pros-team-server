package com.pros.pick.domain.reward.dto;

import com.pros.pick.domain.user.dto.UserRewardDto;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class RewardDto {

    private String description;

    private UserRewardDto userRewardDto;
}
