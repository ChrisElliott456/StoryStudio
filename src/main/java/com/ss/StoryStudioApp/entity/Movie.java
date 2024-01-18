package com.ss.StoryStudioApp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movie_id")
    private Long id;
    private String title;
    private String director;
    private int year;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile")
    private Profile profile;

    public Movie() {
    }

    public Movie(String title, String director, int year, Profile profile) {
        this.title = title;
        this.director = director;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
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
