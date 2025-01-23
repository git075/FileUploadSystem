package com.printshop.controller;

import com.printshop.service.IPAddressUtil;
import com.printshop.service.QRCodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qr")
public class QRCodeController {
    @Autowired
    private QRCodeGeneratorService qrCodeGeneratorService;
    @Autowired()
    private IPAddressUtil ipAddress;
    @Autowired
    private ConfigController ConfigController;

    @GetMapping("/{shopId}")
    public ResponseEntity<byte[]> getQRCode(@PathVariable String shopId) throws Exception { 
    	//String hostAddress = ipAddress.getIpAddress();
        ResponseEntity<String> hostAddressResponse = ConfigController.getApiBaseUrl();
        String hostAddress = hostAddressResponse.getBody();
        String shopUrl = "http://" + hostAddress + ":8080/api/files/" + shopId + "/upload-form";
        byte[] qrCode = qrCodeGeneratorService.generateQRCode(shopUrl, 200, 200);
        
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG)
            .body(qrCode);
    }
}




