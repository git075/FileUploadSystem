package com.printshop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;

import java.nio.file.Path;

@Service
@CrossOrigin(origins = "*")
@RequestMapping("/api/files")
public class FileDownloadService {
    private final String LOCAL_FOLDER =  "C:/users/shank/uploads/";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Fetches files for all registered shops periodically.
     */
    /*
    @Scheduled(fixedRate = 15000) // Check every 15 seconds
    public void fetchFilesForAllShops() {
        try {
            // Fetch all shop IDs from the API
            List<String> shopIds = restTemplate.getForObject("http://localhost:8080/api/shops", List.class);

            if (shopIds != null) {
                for (String shopId : shopIds) {
                    fetchFilesForShop(shopId);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching shops: " + e.getMessage());
        }
    }

    /**
     * Fetches files for a specific shop based on the shopId.
     * @param shopId The ID of the shop to fetch files for.
     */
    /*
    private void fetchFilesForShop(String shopId) {
        try {
            // Fetch file names for the given shop
            List<String> files = restTemplate.getForObject(
                "http://localhost:8080/api/files/{shopId}/download",
                List.class,
                Map.of("shopId", shopId)
            );

            if (files != null) {
                for (String fileName : files) {
                    downloadAndSaveFile(shopId, fileName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching files for shop " + shopId + ": " + e.getMessage());
        }
    }

    /**
     * Downloads and saves a file for a specific shop.
     * @param shopId The ID of the shop the file belongs to.
     * @param fileName The name of the file to download.
     */
    /*
    private void downloadAndSaveFile(String shopId, String fileName) {
        try {
            // Download the file from the API
            byte[] fileData = restTemplate.getForObject(
                "http://localhost:8080/api/files/{shopId}/download/{fileName}",
                byte[].class,
                Map.of("shopId", shopId, "fileName", fileName)
            );

            if (fileData != null) {
                // Save the file locally under the shop's directory
                File shopDirectory = new File(LOCAL_FOLDER + shopId);
                if (!shopDirectory.exists()) {
                    shopDirectory.mkdirs();
                }

                File file = new File(shopDirectory, fileName);
                Files.write(file.toPath(), fileData);

                System.out.println("File downloaded and saved: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Error downloading file " + fileName + " for shop " + shopId + ": " + e.getMessage());
        }
    }
    */
    
    
    
   // @GetMapping("/{shopId}/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String shopId, @PathVariable String fileName) {
        try {
            String filePath = LOCAL_FOLDER + shopId + "/" + fileName;
            File file = new File(filePath);

            if (!file.exists() || !file.canRead()) {
                System.err.println("File not found or not readable: " + filePath);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            Path path = file.toPath();
            Resource resource = new UrlResource(path.toUri());
            System.out.println("File found, serving: " + path.toUri());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                    .body(resource);
 
        } catch (IOException e) {
            System.err.println("Error during file download: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}























/*
package com.printshop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;

@Service
public class FileDownloadService {
    private final String LOCAL_FOLDER = "C:/PrintShop/";

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(fixedRate = 15000) // Check every 15 seconds
    public void fetchFiles() {
        try {
            List<String> files = restTemplate.getForObject("http://localhost:8080/api/files/{shopId}/download", List.class, Map.of("shopId", "1"));

            if (files != null) {
                for (String fileName : files) {
                    byte[] fileData = restTemplate.getForObject("http://localhost:8080/api/files/{shopId}/download/{fileName}", byte[].class, Map.of("shopId", "1", "fileName", fileName));
                    File file = new File(LOCAL_FOLDER + fileName);
                    Files.write(file.toPath(), fileData);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching files: " + e.getMessage());
        }
    }
}

*/

//Java's File and Path APIs are used to interact with the local file system.
//The application relies on the permissions of the operating system user running the Spring Boot application.