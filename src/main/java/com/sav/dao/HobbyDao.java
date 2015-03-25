package com.sav.dao;

import com.sav.model.Contact;
import com.sav.model.Hobby;

import java.util.Set;

public interface HobbyDao {
    void addHobby(Hobby hobby);
    Set<Contact> getAllContactsWithHobby(Hobby hobby);
}
