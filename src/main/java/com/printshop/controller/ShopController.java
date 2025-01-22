package com.printshop.controller;

import com.printshop.entity.Shop;
import com.printshop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController  //This is restController and not controller only, this usually return api responses in JSON or XML form as we can see in the return line of below function
@RequestMapping("/api/shop")
public class ShopController {
    @Autowired
    private ShopRepository shopRepository;

    @PostMapping("/register")
    public ResponseEntity<String> registerShop(@RequestBody Shop shop) {
        // Use your local or server address here
        String baseUrl = "http://localhost:8080"; // Change to your actual backend URL if hosted elsewhere

        // Generate the QR Code URL with the correct base URL
        String qrCodeUrl = baseUrl + "/api/shop/" + UUID.randomUUID();
        shop.setQrCode(qrCodeUrl);

        // Save the shop to the database
        shopRepository.save(shop);

        return ResponseEntity.ok("Shop registered successfully. QR Code: " + shop.getQrCode());
    }
}
