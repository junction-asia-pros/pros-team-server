package com.pros.pick.domain.shop.dto.shoplist;

import com.pros.pick.domain.bowl.entity.Bowl;
import com.pros.pick.domain.shop.dto.ShopLocationResponseDto;
import com.pros.pick.domain.shop.entity.ShopLocation;
import lombok.*;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ShopListResponseDto {
    private String name;

    private Blob image;

    private ShopLocationResponseDto shopLocationResponseDto;

    private Map<String, Integer> bowlTypeAndCount = new HashMap<>();

//    private List<BowlShopListResponseDto> list;


}
