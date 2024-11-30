package com.example.main.checkface;

import com.example.main.response.ApiResponse;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

// sudo curl -X POST http://localhost:8080/model/check_face -H "Content-Type: multipart/form-data" -F file=@/home/codecraftman/Pictures/shop4.jpg

@RestController
public class CheckFace {
    @PostMapping("/model/check_face")
    public ResponseEntity<ApiResponse> checkFace(
            @RequestParam(name = "file") MultipartFile file
    ) throws IOException {
        String recognizedUuid = "recognized-uuid-here";

        ApiResponse response = new ApiResponse("success", "Face recognized.", recognizedUuid);
        return ResponseEntity.ok(response);
    }
}