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

    @GetMapping("/{shopId}")
    public ResponseEntity<byte[]> getQRCode(@PathVariable String shopId) throws Exception { //Changed shopid to string from long.
       // String shopUrl = "http://localhost:8080/shop/" + shopId;
    	String hostAddress = ipAddress.getIpAddress();
       // String shopUrl = "http://172.21.88.60:8080/api/files/" + shopId + "/upload-form";//Because if there were localhost, then only if i scan the qr with this pc then it would work because scanning through phone will understand localhost to itself. Also the server is running of this pc.
        String shopUrl = "http://" + hostAddress + ":8080/api/files/" + shopId + "/upload-form";
        byte[] qrCode = qrCodeGeneratorService.generateQRCode(shopUrl, 200, 200);
        
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG)
            .body(qrCode);
    }
}




