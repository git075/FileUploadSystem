package com.printshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.printshop.client.FileDownloadService;



@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins="*")
public class FileDownloadController {
	
	@Autowired
	private FileDownloadService fileDownloadService;
	
	
	 @GetMapping("/{shopId}/download/{fileName}")
	 public ResponseEntity<Resource> downloadFile(@PathVariable String shopId, @PathVariable String fileName ){
		 return fileDownloadService.downloadFile(shopId, fileName);
	 }
	

}
