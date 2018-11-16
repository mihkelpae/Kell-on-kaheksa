package com.example.demo.entities;

import javax.persistence.*;

@Table(name="os")
@Entity
public class OS {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="URI")
    private String URI;

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

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

    public OS(String name, String URI) {
        this.name = name;
        this.URI = URI;
    }

    public OS() {}
}
