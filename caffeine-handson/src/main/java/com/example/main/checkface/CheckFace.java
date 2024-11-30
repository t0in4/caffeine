package com.example.main.checkface;

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
    public ResponseEntity<String> checkFace(
            @RequestParam(name = "file") MultipartFile file
    ) throws IOException {
        // Save the uploaded file (optional, depending on your use case)
        checkFile(file);

        // Here you would implement the logic to check the face
        // For demonstration, we'll just return a success message
        return ResponseEntity.ok("Face check successful for file: " + file.getOriginalFilename());
    }

    private String checkFile(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            File originalFile = new File("/home/codecraftman/Pictures/shop4.jpg");
            BufferedInputStream input1 = new BufferedInputStream(new FileInputStream(convertMultipartFileToFile(file)));
            BufferedInputStream input2 = new BufferedInputStream(new FileInputStream(originalFile));

            int ch1 = input1.read();
            int ch2 = input2.read();

            while (ch1 != -1 && ch2 != -1) {
                if (ch1 != ch2) {
                    return "Face not recognized";
                }
                ch1 = input1.read();
                ch2 = input2.read();
            }



        }
        return "Face recognized";
    }

    private File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        // Create a temporary file
        File file = new File(System.getProperty("java.io.tmpdir") + "/" + multipartFile.getOriginalFilename());

        // Transfer the contents of the MultipartFile to the File
        multipartFile.transferTo(file);

        return file;
    }
}