package com.example.main.removeface;

import org.springframework.web.multipart.MultipartFile;

public class Model {


    private String uuid;
    private MultipartFile file;

    // Constructor
    public Model(String uuid) {
        this.uuid = uuid;
    }

    // Getter
    public String getUuid() {
        return uuid;
    }

    // Setter
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    // Getter for file
    public MultipartFile getFile() {
        return file;
    }

    // Setter for file
    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
