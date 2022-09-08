package com.socialnetwork;

import com.socialnetwork.model.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Mocks {

    public static Profile getProfile(){
        return new Profile(0L,"teste@email.com", "teste", "123456", LocalDateTime.now(), LocalDate.now(), true, true, "teste", "12345678", null, null, null, null, null, null, null, null,null);
    }

    public static List<Profile> getProfileList(int size){
        List<Profile> profileList = new ArrayList<>();

        for (int i = 0; i < size; i++)
            profileList.add(getProfile());

        return profileList;
    }


}
