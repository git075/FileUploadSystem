package com.printshop.controller;

import com.printshop.entity.Shop;
import com.printshop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController  
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerShop(@RequestBody Shop shop) {
        
        String baseUrl = "http://localhost:8080"; // Change to your actual backend URL if hosted elsewhere

      
        String qrCodeUrl = baseUrl + "/api/shop/" + UUID.randomUUID();
        shop.setQrCode(qrCodeUrl);

        // Save the shop to the database
        shopRepository.save(shop);

        return ResponseEntity.ok("Shop registered successfully. QR Code: " + shop.getQrCode());
    }
}
