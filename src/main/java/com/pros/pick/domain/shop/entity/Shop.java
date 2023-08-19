package com.pros.pick.domain.shop.entity;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.pros.pick.aws.S3FileController;
import com.pros.pick.aws.S3FileService;
import com.pros.pick.domain.bowl.entity.Bowl;
import com.pros.pick.domain.shop.dto.ShopDto;
import com.pros.pick.domain.shop.dto.list.ShopListResponseDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    // 가게명
    @Column(nullable = false)
    private String name;

    // 가게 이미지
    private String imageUrl;

    // 가게 위치 정보
    @OneToOne
    @JoinColumn(name="shop_location_id")
    private ShopLocation shopLocation;

    // 가게의 다회용 그릇
    @OneToMany(mappedBy = "shop", cascade = ALL)
    private List<Bowl> list = new ArrayList<>();

    // 다회용 그룹 타입 - 현재 미사용
    @Column
    private String bowlType;

    // 반납 상태
    @Column
    private boolean receiveStatus;

    @Builder
    public Shop(Long id, String name, String imageUrl, ShopLocation shopLocation,  String bowlType, boolean receiveStatus) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.shopLocation = shopLocation;
//        this.list = list;
        this.bowlType = bowlType;
        this.receiveStatus = receiveStatus;
    }

    public static Shop toEntity(ShopDto shopDto){
        return Shop.builder()
                .id(shopDto.getId())
                .name(shopDto.getName())
                .imageUrl(shopDto.getImageUrl())
                .shopLocation(shopDto.getShopLocation())
//                .list(shopDto.getList())
                .bowlType(shopDto.getBowlType())
                .receiveStatus(shopDto.isReceiveStatus())
                .build();
    }

//    S3FileService s3FileService = new S3FileService(AmazonS3);

    public static ShopListResponseDto toListResponseDto(Shop shop){
        AmazonS3 amazonS3 = new AmazonS3Client();
        S3FileService s3FileService = new S3FileService(amazonS3);
        
        return ShopListResponseDto.builder()
                .name(shop.getName())
                .imageUrl(s3FileService.getImageUrl(shop.getId().toString()))
                .shopLocationResponseDto(ShopLocation.toDto(shop.getShopLocation()))
                .bowlTypeAndCount(shop.getList().stream()
                        .flatMap(bowl -> bowl.getBowlCountList().entrySet().stream())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                .bowlType(shop.getBowlType())
                .build();
//                .flatMap(bowl -> bowl.getBowlSizeCounts().entrySet().stream())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum)));
//                .build();
    }

//    public static ShopDto toDto

    public void updateShopDetails(ShopDto shopDto){
        this.name = shopDto.getName();
        this.imageUrl = shopDto.getImageUrl();
        this.shopLocation = shopDto.getShopLocation();
//        this.list = shopDto.getList();
    }

    public void updateBowlReceiveStatus(String bowlType){
        if (this.bowlType.equals(bowlType)) {
            this.receiveStatus = true;
        }
    }
}
