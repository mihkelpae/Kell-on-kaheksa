package com.example.demo.entities;

import javax.persistence.*;


@Entity
@Table(name = "files")
public class Files {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private String id;

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    public Files() {
    }

    public Files(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public String getId() {
        return id;
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
}
