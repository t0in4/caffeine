package com.example.main.addface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
public class ModelController {

    @PostMapping("/model/add_face1")
    public ResponseEntity<Model> addFace(
                                         @RequestParam(name = "data", required = true) Model data,
                                         @RequestParam(name = "file", required = false) MultipartFile file
                                         ) throws IOException {
        saveUpladedFile(file);
        return ResponseEntity.ok(data);
    }

    private void saveUpladedFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(Objects.requireNonNull(file.getOriginalFilename()));
            Files.write(path, bytes);
        }
    }
}
