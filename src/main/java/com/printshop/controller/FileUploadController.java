package com.printshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/files")
public class FileUploadController {
	private final String UPLOAD_DIR = "C:/users/shank/uploads/"; 


    @PostMapping("/{shopId}/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String shopId) throws IOException {
        String filePath = UPLOAD_DIR + shopId + "/" + file.getOriginalFilename();
        File directory = new File(UPLOAD_DIR + shopId);
        if (!directory.exists()) directory.mkdirs();
        file.transferTo(new File(filePath));
        return ResponseEntity.ok("File uploaded successfully.");
    }
    
                                                                 
    @GetMapping("/{shopId}/upload-form")
    public ResponseEntity<String> getUploadForm(@PathVariable String shopId) {
        String response = "<html>" +
                          "<body>" +
                          "<h1>Upload File</h1>" +
                          "<form action='/api/files/" + shopId + "/upload' method='POST' enctype='multipart/form-data'>" +
                          "<label for='file'>Choose a file:</label>" +
                          "<input type='file' id='file' name='file' required>" +
                          "<button type='submit'>Upload</button>" +
                          "</form>" +
                          "</body>" +
                          "</html>";
        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(response);
    }  
    
    
    @GetMapping("/{shopId}/download")
    public ResponseEntity<List<String>> getFiles(@PathVariable String shopId) {
        File directory = new File(UPLOAD_DIR + shopId);

       
        System.out.println("Checking directory: " + directory.getAbsolutePath());

        if (!directory.exists()) {
            System.out.println("Directory does not exist: " + directory.getAbsolutePath());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList("Directory does not exist."));
        }

        String[] files = directory.list();

        if (files == null || files.length == 0) {
            System.out.println("No files found in directory: " + directory.getAbsolutePath());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Arrays.asList("No files available for this shop."));
        }

        // Logging the files found
        System.out.println("Files found: " + Arrays.toString(files));
        return ResponseEntity.ok(Arrays.asList(files));
    }

    
    
    
    
}
 
