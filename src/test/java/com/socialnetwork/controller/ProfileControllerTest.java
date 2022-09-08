package com.socialnetwork.controller;

import com.socialnetwork.model.Profile;
import com.socialnetwork.repository.ProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;

public class ProfileControllerTest {

    private ProfileController profileController;

    @Mock
    ProfileRepository profileRepository;

    @BeforeEach
    public void initializer(){
        profileRepository = Mockito.mock(ProfileRepository.class);
        this.profileController = new ProfileController(profileRepository);
    }

    @Test
    void getAllSucess(){
        when(profileRepository.findAll()).thenReturn(criarLista());

        ResponseEntity<List<Profile>> answer = profileController.getAll();

        Assertions.assertEquals(1, answer.getBody().size());
    }

    @Test
    void getAllFail(){
        when(profileRepository.findAll()).thenReturn(new ArrayList<Profile>());

        ResponseEntity<List<Profile>> answer = profileController.getAll();

        Assertions.assertEquals(0, answer.getBody().size());
    }






    private ArrayList criarLista(){

        Profile profile = new Profile(0L,"teste@email.com", "teste", "123456", LocalDateTime.now(), LocalDate.now(), true, true, "teste", "12345678", null, null, null, null, null, null, null, null,null);
    ArrayList<Profile> profileList = new ArrayList<>();
    profileList.add(profile);

    return profileList;
    }
}
