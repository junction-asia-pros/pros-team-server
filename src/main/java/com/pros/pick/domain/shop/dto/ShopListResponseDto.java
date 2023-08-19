package com.pros.pick.domain.shop.dto;

import com.pros.pick.domain.bowl.entity.Bowl;
import com.pros.pick.domain.shop.entity.ShopLocation;
import lombok.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ShopListResponseDto {
    private String name;

    private Blob image;

    private ShopLocation shopLocation;

    private String bowlType;

    private boolean receiveStatus;
}
