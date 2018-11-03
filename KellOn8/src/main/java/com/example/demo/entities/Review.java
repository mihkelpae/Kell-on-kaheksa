package com.example.demo.entities;

import javax.persistence.*;

@Table(name = "reviews")
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reply")
    private String reply;

    @Column(name="author")
    private String author;

    @Column(name="byEmail")
    private String byEmail;

    public String getByEmail() {
        return byEmail;
    }

    public void setByEmail(String byEmail) {
        this.byEmail = byEmail;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }


}
