package com.sav.service;

import com.sav.model.Contact;
import com.sav.model.Hobby;
import com.sav.model.Place;

import java.util.Date;
import java.util.List;

public interface ContactService {
    void createContact(String firstName, String lastName, Date birthDate);
    List<Contact> getAllContacts();

    void addHobby(String title, String description);
    List<Hobby> getAllHobbies();

    void addPlace(String title, double longitude, double latitude);
    List<Place> getAllPlaces();
}
