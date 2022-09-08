package com.socialnetwork.controller;

import com.socialnetwork.Mocks;
import com.socialnetwork.model.Profile;
import com.socialnetwork.repository.ProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

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
        when(profileRepository.findAll()).thenReturn(Mocks.getProfileList(1));

        ResponseEntity<List<Profile>> answer = profileController.getAll();

        Assertions.assertEquals(1, answer.getBody().size());
    }

    @Test
    void getAllFail(){
        when(profileRepository.findAll()).thenReturn(new ArrayList<Profile>());

        ResponseEntity<List<Profile>> answer = profileController.getAll();

        Assertions.assertEquals(0, answer.getBody().size());
    }

    @Test
    void getByIdSuccess(){
        when(profileRepository.findById(anyLong())).thenReturn(Optional.of(Mocks.getProfile()));

        Optional<ResponseEntity<Profile>> answer = profileController.getById(0L);

        Assert.notNull(answer);
    }

    @Test
    void getByIdFail(){
        when(profileRepository.findById(anyLong())).thenReturn(Optional.empty());

        Optional<ResponseEntity<Profile>> answer = profileController.getById(0L);

        Assertions.assertTrue(answer.isEmpty());
    }

    @Test
    void getByNomeSuccess(){
        when(profileRepository.findAllByNameContainingIgnoreCase(anyString()))
                .thenReturn(Mocks.getProfileList(1));

        ResponseEntity<List<Profile>> answer = profileController.getByNome("teste");

        Assertions.assertEquals(1, answer.getBody().size());

    }
    @Test
    void getByNomeFail(){
        when(profileRepository.findAllByNameContainingIgnoreCase(anyString()))
                .thenReturn(new ArrayList<>());

        ResponseEntity<List<Profile>> answer = profileController.getByNome(null);

        Assertions.assertEquals(0, answer.getBody().size());
    }

    @Test
    void getByCpfSuccess(){
        when(profileRepository.findAllByDocumentContainingIgnoreCase(anyString()))
                .thenReturn(Mocks.getProfileList(1));

        ResponseEntity<List<Profile>> answer = profileController.getByCpf("123456");

        Assertions.assertEquals(1, answer.getBody().size());
    }

    @Test
    void getByCpfFail(){
        when(profileRepository.findAllByDocumentContainingIgnoreCase(anyString()))
                .thenReturn(new ArrayList<>());

        ResponseEntity<List<Profile>> answer = profileController.getByCpf("123456");

        Assertions.assertEquals(0, answer.getBody().size());

    }

    @Test
    void PostSuccess(){
        when(profileRepository.save(any())).thenReturn(Mocks.getProfile());

        ResponseEntity<Profile> answer = profileController.post(Mocks.getProfile());

        Assert.notNull(answer);
        Mockito.verify(profileRepository, times(1)).save(any());
    }

    @Test
    void PostFail(){
        when(profileRepository.save(any())).thenReturn(null);

        ResponseEntity<Profile> answer = profileController.post(null);

        Assert.isNull(answer.getBody());

    }

    @Test
    void PutSuccess(){
        when(profileRepository.findById(anyLong()))
                .thenReturn(Optional.of(Mocks.getProfile()));
        when(profileRepository.save(any()))
                .thenReturn(Mocks.getProfile());

        ResponseEntity<Profile> answer = profileController.put(0L, Mocks.getProfile());

        Assert.notNull(answer);
    }

    @Test
    void putFail(){
        when(profileRepository.findById(anyLong()))
                .thenReturn(Optional.empty());
        when(profileRepository.save(any()))
                .thenReturn(null);

        ResponseEntity<Profile> answer = profileController.put(null, null);

        Assert.isNull(answer.getBody());
    }

    @Test
    void deleteSuccess(){
        when(profileRepository.findById(anyLong())).thenReturn(Optional.of(Mocks.getProfile()));
        doNothing().when(profileRepository).deleteById(Mockito.notNull());

        profileController.delete(anyLong());

        Mockito.verify(profileRepository, times(1)).findById(anyLong());
        Mockito.verify(profileRepository, times(1)).deleteById(notNull());
    }

    @Test
    void deleteFail(){
        when(profileRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new Profile()));
        doNothing().when(profileRepository).deleteById(Mockito.notNull());

        profileController.delete(anyLong());
        assertThrows(ResponseStatusException.class, () -> profileController.delete(null));
    }







}
