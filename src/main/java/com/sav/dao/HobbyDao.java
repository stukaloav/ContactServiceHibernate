package com.sav.dao;

import com.sav.model.Contact;
import com.sav.model.Hobby;

import java.util.List;

public interface HobbyDao {
    void addHobby(Hobby hobby);
    List<Contact> getAllContactsWithHobby(Hobby hobby);
    List<Hobby> getAllHobbies();
}
