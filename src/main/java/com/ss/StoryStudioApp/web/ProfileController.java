package com.ss.StoryStudioApp.web;

import com.ss.StoryStudioApp.entity.Profile;
import com.ss.StoryStudioApp.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/StoryStudio/profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getProfiles(@PathVariable Long id){
        return new ResponseEntity<>(profileService.getProfiles(id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id){
        return new ResponseEntity<>(profileService.getProfileById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Profile> addProfile(@RequestBody Profile profile){
        return new ResponseEntity<>(profileService.addProfile(profile), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Profile> deleteProfileById(@PathVariable Long id){
        profileService.deleteProfileById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile){
        return new ResponseEntity<>(profileService.updateProfile(id, profile), HttpStatus.ACCEPTED);
    }
}
