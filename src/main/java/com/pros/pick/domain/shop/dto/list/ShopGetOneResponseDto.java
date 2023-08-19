package com.pros.pick.domain.shop.dto.list;

import com.pros.pick.domain.shop.entity.ShopLocation;
import lombok.*;

import java.sql.Blob;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ShopGetOneResponseDto {
    private String name;

    private Blob image;

    private ShopLocation shopLocation;
}
