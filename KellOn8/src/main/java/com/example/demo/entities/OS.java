package com.example.demo.entities;

import javax.persistence.*;

@Table(name="os")
@Entity
public class OS {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="opsys")
    private String opsys;

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
        return opsys;
    }

    public void setName(String name) {
        this.opsys = name;
    }

    public OS(String name, String URI) {
        this.opsys = name;
        this.URI = URI;
    }

    public OS() {}
}
