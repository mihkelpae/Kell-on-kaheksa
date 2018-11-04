package com.example.demo.entities;

import javax.persistence.*;

@Table(name="userPictures")
@Entity
public class UserPictures {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="fileName")
    private String fileName;

    @Column(name="fileType")
    private String fileType;

    @Lob
    @Column(name="data")
    private byte[] data;

    @Column(name="owner")
    private String owner;

    public UserPictures() {}

    public UserPictures(String fileName, String fileType, byte[] data, String owner) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.owner = owner;
    }

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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
