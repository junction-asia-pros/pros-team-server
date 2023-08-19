package com.pros.pick.domain.shop.entity;

import com.pros.pick.domain.bowl.entity.Bowl;
import com.pros.pick.domain.shop.dto.ShopDto;
import com.pros.pick.domain.shop.dto.ShopListResponseDto;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Shop {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    private Blob image;

    @OneToOne
    @JoinColumn(name="shop_location_id")
    private ShopLocation shopLocation;

    //bowl:shop n:1
    @OneToMany(mappedBy = "shop", cascade = ALL)
    private List<Bowl> list = new ArrayList<>();

    //    용기 타입: abc
    @Column
    private String bowlType;

    @Column
    private boolean receiveStatus;

    @Builder
    public Shop(Long id, String name, Blob image, ShopLocation shopLocation, List<Bowl> list, String bowlType, boolean receiveStatus) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.shopLocation = shopLocation;
        this.list = list;
        this.bowlType = bowlType;
        this.receiveStatus = receiveStatus;
    }

    public static Shop toEntity(ShopDto shopDto){
        return Shop.builder()
                .id(shopDto.getId())
                .name(shopDto.getName())
                .image(shopDto.getImage())
                .shopLocation(shopDto.getShopLocation())
                .list(shopDto.getList())
                .bowlType(shopDto.getBowlType())
                .receiveStatus(shopDto.isReceiveStatus())
                .build();
    }

    public static ShopListResponseDto toListResponseDto(Shop shop){
        return ShopListResponseDto.builder()
                .name(shop.getName())
                .image(shop.getImage())
                .shopLocation(shop.getShopLocation())
                .bowlType(shop.getBowlType())
                .receiveStatus(shop.isReceiveStatus())
                .build();

    }

//    public static ShopDto toDto

    public void updateShopDetails(ShopDto shopDto){
        this.name = shopDto.getName();
        this.image = shopDto.getImage();
        this.shopLocation = shopDto.getShopLocation();
        this.list = shopDto.getList();
    }

    public void updateBowlReceiveStatus(String bowlType){
        if (this.bowlType.equals(bowlType)) {
            this.receiveStatus = true;
        }
    }
}
