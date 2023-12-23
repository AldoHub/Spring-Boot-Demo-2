package com.test.photosTest;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table
public class Photo {
    public Photo() {
    }

    public Photo(Long id, String fileName, String mimeType) {
        this.id = id;
        this.fileName = fileName;
        this.mimeType = mimeType;

    }

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @NotEmpty
    private String fileName;
    @NotEmpty
    private String mimeType;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @NotEmpty
    @JsonIgnore
    @Column(length = 65555)
    private byte[] data;
}
