package com.example.demo.entities;

import javax.persistence.*;

@Table(name="browser")
@Entity
public class Browser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name="browser")
    private String browser;

    @Column(name="URI")
    private String URI;

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public Browser(String browser, String URI) {
        this.browser = browser;
        this.URI = URI;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
