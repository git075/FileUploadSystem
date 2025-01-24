package com.printshop.controller;

import com.printshop.entity.Shop;
import com.printshop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@RestController
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    

    @Value("${api.base.url}")
    private String apiBaseUrl;


    @PostMapping("/register")
    public ResponseEntity<String> registerShop(@RequestBody Shop shop) {



        String qrCodeUrl = apiBaseUrl + "/api/shop/" + UUID.randomUUID();
        shop.setQrCode(qrCodeUrl);


        shopRepository.save(shop);

        return ResponseEntity.ok("Shop registered successfully. QR Code: " + shop.getQrCode());
    }
}
