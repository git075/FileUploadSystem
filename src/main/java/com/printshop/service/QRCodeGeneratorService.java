package com.printshop.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class QRCodeGeneratorService {
	
	@Autowired
	ByteArrayOutputStream byteArrayOutputStream;
	 
	
//    public QRCodeGeneratorService(ByteArrayOutputStream byteArrayOutputStream) {
//		super();
//		this.byteArrayOutputStream = byteArrayOutputStream;
//	}


	public byte[] generateQRCode(String data, int width, int height) throws WriterException, IOException {
        BitMatrix bitMatrix = new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, width, height);
       // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}