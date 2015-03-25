package com.sav.service;

import com.sav.model.Contact;
import com.sav.model.Hobby;

import java.util.Date;
import java.util.List;

public interface ContactService {
    void createContact(String firstName, String lastName, Date birthDate);
    List<Contact> getAllContacts();

    void addHobby(String title, String description);
    List<Hobby> getAllHobbies();
}
