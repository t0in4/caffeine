package com.example.main.addface;

import com.example.main.responaes.Face;
import com.example.main.responaes.FacesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// sudo curl -X POST http://localhost:8080/model/add_face -H "Content-Type: multipart/form-data" -F "data={\"uuid\": \"your-uuid-here\"};type=application/json" -F file=@/home/codecraftman/Pictures/shop4.jpg
// sudo curl -X GET http://localhost:8080/model/get_faces
@RestController
@RequestMapping("/model")
public class ModelController {
    private List<Face> faces = new ArrayList<>();
    @PostMapping("/add_face")
    public ResponseEntity<String> addFace(
                                         @RequestParam(name = "data", required = true) String data,
                                         @RequestParam(name = "file", required = false) MultipartFile file
                                         ) throws IOException {
        try {
            System.out.println("Received data: " + data);
            if (file != null) {
                System.out.println("Received file: " + file.getOriginalFilename());
            }

            saveUploadedFile(file);
            Face newFace = new Face(data);
            faces.add(newFace);
            System.out.println("Face added: " + newFace);

            return ResponseEntity.ok("Face added successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error saving file: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
        }
    }
    @GetMapping("/get_faces")
    public ResponseEntity<FacesResponse> getFaces() {
        FacesResponse response = new FacesResponse("success", faces);
        System.out.println(response.getStatus());
        System.out.println(response.getStatus());
        return ResponseEntity.ok(response);
    }

    private void saveUploadedFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(Objects.requireNonNull(file.getOriginalFilename()));
            Files.write(path, bytes);
        }
    }
}
