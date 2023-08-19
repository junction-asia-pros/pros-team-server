package com.pros.pick.aws;

import com.amazonaws.services.s3.AmazonS3;
import com.pros.pick.domain.shop.entity.Shop;
import com.pros.pick.domain.shop.repository.ShopRepository;
import com.pros.pick.domain.shop.service.ShopService;
import com.pros.pick.domain.user.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;

@RequiredArgsConstructor
@RequestMapping("/s3")
@RestController
public class S3FileController {
    private final S3FileService s3FileService;

    private final ShopService shopService;

    private final AmazonS3 s3Client;

    @Operation(summary = "upload file to S3")
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile multipartFile)
            throws IOException{
        return ResponseEntity.ok(s3FileService.upload(multipartFile));
    }

    @Operation(summary = "delete uploaded file from S3")
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteFile(@RequestParam String fileName){
        //fileName to be modified to under member username
        s3FileService.deleteFile(fileName);
        return ResponseEntity.ok(null);
    }

    @Operation(summary = "get image url")
    @GetMapping("/get/{shop-id}")
    public ResponseEntity<String> getShopImage(@PathVariable("shop-id") String shopId) {
//        Shop shop = shopService.findById(shopId);
        URL url = s3Client.getUrl("street-drop", shopId);
        return ResponseEntity.ok(url.toString() + ".png");
    }
}
