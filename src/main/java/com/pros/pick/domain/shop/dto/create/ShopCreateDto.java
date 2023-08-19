package com.pros.pick.domain.shop.dto.create;

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
public class ShopCreateDto {
    private String name;

    private String imageUrl;

    private ShopLocation shopLocation;

    private String bowlType;

    private boolean receiveStatus;
}
