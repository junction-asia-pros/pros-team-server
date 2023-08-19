package com.pros.pick.domain.shop.dto.list;

import com.pros.pick.domain.shop.dto.ShopLocationResponseDto;
import lombok.*;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ShopListResponseDto {
    private String name;

    private String imageUrl;

    private ShopLocationResponseDto shopLocationResponseDto;

    private Map<String, Integer> bowlTypeAndCount = new HashMap<>();

    private String bowlType;


}
