package com.pros.pick.domain.shop.dto;

import com.pros.pick.domain.bowl.entity.Bowl;
import com.pros.pick.domain.shop.entity.ShopLocation;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ShopDto {
    private Long id;

    private String name;

    private String imageUrl;

    private ShopLocation shopLocation;

    private List<Bowl> list = new ArrayList<>();

    private String bowlType;

    private boolean receiveStatus;
}
