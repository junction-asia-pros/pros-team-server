package com.pros.pick.domain.shop.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Blob;
import java.util.ArrayList;

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
}
