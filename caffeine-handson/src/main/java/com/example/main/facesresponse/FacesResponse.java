package com.example.main.facesresponse;

import java.util.List;

public class FacesResponse {
    private String status;
    private List<Face> faces;

    public FacesResponse(String status, List<Face> faces) {
        this.status = status;
        this.faces = faces;
    }

    public String getStatus() {
        return status;
    }

    public List<Face> getFaces() {
        return faces;
    }
}
