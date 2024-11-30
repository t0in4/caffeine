package com.example.main.responaes;

import java.util.List;

public class FacesResponse {
    private String status;
    private List<Face> faces;

    public FacesResponse(String status, List<Face> faces) {
        this.status = status;
        this.faces = faces;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public void setFaces(List<Face> faces) {
        this.faces = faces;
    }
}

