package com.example.main.getfaces;


import com.example.main.di.Storage;
import com.example.main.facesresponse.FacesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetFaces {
    private Storage storage;


    @GetMapping("/model/get_faces")
    public ResponseEntity<FacesResponse> getFaces() {
        storage = new Storage();
        FacesResponse response = storage.getFacesResponses();
        return ResponseEntity.ok(response);
    }

}
