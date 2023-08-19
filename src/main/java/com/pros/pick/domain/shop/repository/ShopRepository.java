package com.pros.pick.domain.shop.repository;

import com.pros.pick.domain.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop,Long> {
    Optional<Shop> findById(Long id);

    Optional<Shop> findByBowlType(String bowlType);

    void deleteById(Long id);
}
