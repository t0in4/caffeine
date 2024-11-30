package com.example.main.removeface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RemoveFace {
    @DeleteMapping("/model/remove_face")
    public ResponseEntity<String> removeFace(@RequestBody Model model) {
        // Logic to remove the face using the UUID
        String uuid = model.getUuid();
        // Here you would typically call a service to handle the deletion logic
        // For example: faceService.removeFace(uuid);

        // For demonstration, we'll just return a success message
        return ResponseEntity.ok("Face with UUID " + uuid + " has been removed.");
    }
}