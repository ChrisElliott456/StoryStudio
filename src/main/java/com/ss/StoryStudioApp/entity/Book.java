package com.ss.StoryStudioApp.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;
    private String title;
    private String author;
    private int year;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile")
    private Profile profile;

    public Book() {
    }

    public Book(String title, String author, int year, Profile profile) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.profile = profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
