package com.sav.service;

import com.sav.model.Contact;
import com.sav.model.Friendship;
import com.sav.model.Hobby;
import com.sav.model.Place;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ContactService {
    //Methods that deal with ContactDao
    void createContact(String firstName, String lastName, Date birthDate);
    Set<Contact> getAllContacts();
    void addHobbyToContact(Contact contact, Hobby hobby);
    Contact getContactById(long id);
    void addContact(Contact contact);

    @Transactional
    void deleteContact(Contact contact);

    @Transactional
    Long getIdFromContact(Contact contact);

    Set<Hobby> getHobbiesFromContact(Contact contact);

    @Transactional
    void addFriendship(Contact first, Contact second);

    @Transactional
    List<Friendship> getAllFriendPairs();

    //Methods that deal with HobbyDao
    void addHobby(String title, String description);
    List<Hobby> getAllHobbies();
    void addHobby(Hobby hobby);

    //Methods that deal with PlaceDao
    void addPlace(String title, double longitude, double latitude);
    List<Place> getAllPlaces();
}
