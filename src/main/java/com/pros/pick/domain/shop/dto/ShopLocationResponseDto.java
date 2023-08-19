package com.pros.pick.domain.shop.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ShopLocationResponseDto {
    private double longitude;

    private double latitude;

    private String address;

}
