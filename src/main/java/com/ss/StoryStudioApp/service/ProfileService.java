package com.ss.StoryStudioApp.service;

import com.ss.StoryStudioApp.entity.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getProfiles(Long id);

    Profile getProfileById(Long id);

    Profile addProfile(Profile profile);

    void deleteProfileById(Long id);

    Profile updateProfile(Long id, Profile profile);
}
