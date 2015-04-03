package com.sav.dao;

import com.sav.model.Contact;
import com.sav.model.ContactHobbies;
import com.sav.model.Hobby;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface HobbyDao {
    @Transactional
    void addHobby(Hobby hobby);
    @Transactional
    void deleteHobbyByTitle(String title);
    @Transactional
    Set<Contact> getAllContactsWithHobby();
    @Transactional
    List<Hobby> getAllHobbies();
    @Transactional
    Hobby getHobbyById(long id);

}
