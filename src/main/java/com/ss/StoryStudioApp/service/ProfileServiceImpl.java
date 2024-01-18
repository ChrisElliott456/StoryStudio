package com.ss.StoryStudioApp.service;

import com.ss.StoryStudioApp.entity.Profile;
import com.ss.StoryStudioApp.repository.ProfileRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getProfiles(Long id) {
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileById(Long id) {
        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()){
            return optionalProfile.get();
        } else {
            throw new EntityNotFoundException("Profile with ID "+id+" not found.");
        }
    }

    @Override
    public Profile addProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfileById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile updateProfile(Long id, Profile profile) {
        Profile existingProfile = getProfileById(id);
        existingProfile.setProfileName(profile.getProfileName());
        existingProfile.setBirthday(profile.getBirthday());
        existingProfile.setGender(profile.getGender());
        profileRepository.save(existingProfile);
        return existingProfile;
    }
}
