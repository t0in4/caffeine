package com.example.main.di;


import com.example.main.facesresponse.Face;
import com.example.main.facesresponse.FacesResponse;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    private List<Face> faces = new ArrayList<>();

    public void addFace(String uuid) {
        faces.add(new Face(uuid));
    }

    public  FacesResponse getFacesResponses() {
        return new FacesResponse("success", faces);
    }



}
