package com.pros.pick.domain.shop.controller;

import com.pros.pick.domain.shop.dto.ShopDto;
import com.pros.pick.domain.shop.dto.ShopListResponseDto;
import com.pros.pick.domain.shop.service.ShopService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    @Operation(summary = "create and save shop")
    @PostMapping("/createShop")
    public ResponseEntity<Long> createShop(@RequestBody @Valid final ShopDto shopDto,
                                           BindingResult bindingResult){
        ResponseEntity<BindingResult> checkViaBindingResult = checkViaBindingResult(bindingResult);
        if (checkViaBindingResult != null) return ResponseEntity.badRequest().build();
        Long shop_id = shopService.createShop(shopDto);
        return ResponseEntity.ok(shop_id);
    }

    //check via binding result
    private ResponseEntity<BindingResult> checkViaBindingResult(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult);
        }
        return null;
    }

    @Operation(summary = "edit regular shop details")
    @PutMapping("/editShopRegularDetails/{id}")
    public ResponseEntity<Void> editShopRegularDetails(@PathVariable final Long id, @RequestBody @Valid final ShopDto shopDto){
        shopService.updateShopDetails(shopDto);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "edit bowl received status")
    @PutMapping("/editShopBowlReceiveStatus/{id}")
    public ResponseEntity<Void> editShopBowlReceiveStatus(@PathVariable final Long id, @RequestBody @Valid final ShopDto shopDto){
        shopService.updateBowlReceiveStatus(shopDto.getBowlType());
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "list all shops")
    @GetMapping("")
    public ResponseEntity<List<ShopListResponseDto>> listAllShops(){
        return ResponseEntity.ok(shopService.listAllShops());
    }

    @Operation(summary = "delete one shop")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@RequestBody @Valid final ShopDto shopDto){
        shopService.deleteShopById(shopDto);
        return ResponseEntity.noContent().build();
    }
}
