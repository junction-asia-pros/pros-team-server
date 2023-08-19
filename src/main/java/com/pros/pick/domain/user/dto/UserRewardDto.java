package com.pros.pick.domain.user.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class UserRewardDto {
    private String username;

    private int accumulatedPointReward;
}
