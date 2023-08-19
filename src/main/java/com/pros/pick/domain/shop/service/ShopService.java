package com.pros.pick.domain.shop.service;

import com.pros.pick.domain.shop.dto.ShopDto;
import com.pros.pick.domain.shop.dto.list.ShopListResponseDto;
import com.pros.pick.domain.shop.entity.Shop;
import com.pros.pick.domain.shop.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ShopRepository shopRepository;

//    create
    @Transactional
    public Long createShop(final ShopDto shopDto){
        validateShopDoesNotExistById(shopDto.getId());
        Shop shop = shopRepository.save(Shop.toEntity(shopDto));
        return shop.getId();
    }

    private void validateShopDoesNotExistById(Long shopId) {
        if (shopRepository.existsById(shopId)) {
            throw new DuplicateKeyException("An existing shop with the same ID already exists");
        }
    }

    private void validateShopDoesNotExistByBowlType(String bowlType) {
        if (shopRepository.findByBowlType(bowlType).isEmpty()) {
            throw new DuplicateKeyException("An existing shop with the same ID already exists");
        }
    }

//    delete
    public void deleteShopById(final ShopDto shopDto){
        validateShopDoesNotExistById(shopDto.getId());
        shopRepository.deleteById(shopDto.getId());
    }

//    update shop details
    public void updateShopDetails(final ShopDto shopDto){
        validateShopDoesNotExistById(shopDto.getId());
        Shop shop = shopRepository.findById(shopDto.getId()).get();
        shop.updateShopDetails(shopDto);
    }

//    update bowl receive status from false to true when bowls are received
    public void updateBowlReceiveStatus(final String bowlType){
        validateShopDoesNotExistByBowlType(bowlType);
        Shop shop = shopRepository.findByBowlType(bowlType).get();
        shop.updateBowlReceiveStatus(bowlType);
    }

//    list
    public List<ShopListResponseDto> listAllShops(){
        List<Shop> list = shopRepository.findAll();
        return list.stream()
                .map(shop -> Shop.toListResponseDto(shop))
                .collect(Collectors.toList());
    }

    public void removeBowlFromQueue(final String bowlType, List<ShopListResponseDto> list){
        list.removeIf(shopListResponseDto -> shopListResponseDto.getBowlType().equals(bowlType));
    }
}
