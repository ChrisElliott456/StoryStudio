package com.ss.StoryStudioApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profileId;
    private String profileName;
    private String birthday;
    private String gender;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
    @JsonIgnore
    private List<Movie> movies;

    public Profile() {
    }

    public Profile(String profileName, String birthday, String gender) {
        this.profileName = profileName;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Profile(String profileName, String birthday, String gender, List<Movie> movies) {
        this.profileName = profileName;
        this.birthday = birthday;
        this.gender = gender;
        this.movies = movies;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
