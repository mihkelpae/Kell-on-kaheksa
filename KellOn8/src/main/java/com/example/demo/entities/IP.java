package com.example.demo.entities;

import javax.persistence.*;

@Table(name="ip")
@Entity
public class IP {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="IP")
    private String name;

    @Column(name="location")
    private String location;

    @Column(name="URI")
    private String URI;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public IP(String name, String URI) {
        this.name = name;
        this.URI = URI;
    }
    public IP() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
