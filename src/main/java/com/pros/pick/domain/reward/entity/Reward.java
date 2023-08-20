package com.pros.pick.domain.reward.entity;

import com.pros.pick.domain.reward.dto.RewardDto;
import com.pros.pick.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Reward {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "reward_id")
    private Long id;

    private String description;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Reward(Long id, String description, User user) {
        this.id = id;
        this.description = description;
        this.user = user;
    }

//    public static Reward toEntity(RewardDto rewardDto){
//        Reward.builder()
//                .description(rewardDto.getDescription())
//                .user(rewardDto.getUserRewardDto())
//    }
}
