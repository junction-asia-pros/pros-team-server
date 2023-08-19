package com.pros.pick.domain.shop.entity;

import com.pros.pick.domain.shop.dto.ShopLocationResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
public class ShopLocation {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "shop_location_id")
    private Long id;

    @Column
    private double longitude;

    @Column
    private double latitude;

    @Column(length = 30)
    private String address;

    public static ShopLocationResponseDto toDto(ShopLocation shopLocation){
        return ShopLocationResponseDto.builder()
                .longitude(shopLocation.getLongitude())
                .latitude(shopLocation.getLatitude())
                .address(shopLocation.getAddress())
                .build();
    }

}
