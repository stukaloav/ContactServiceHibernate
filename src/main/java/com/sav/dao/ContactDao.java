package com.sav.dao;

import com.sav.model.Contact;
import com.sav.model.ContactHobbies;
import com.sav.model.Friendship;
import com.sav.model.Hobby;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface ContactDao {
    void addContact(Contact contact);
    void deleteContact(Contact contact);
    Set<Contact> getAllContacts();

    @Transactional
    Contact getContactById(long id);

    @Transactional
    void addHobbyToContact(Contact id, Hobby hobby);

    @Transactional
    Long getIdFromContact(Contact contact);

    @Transactional
    void addFriendship(Contact first, Contact second);

    @Transactional
    List<Friendship> getAllFriends();

    @Transactional
    Set<Contact> getFriendsFromContact(Contact contact);

    @Transactional
    Set<Contact> getAllContactsSamePlace(String placeTitle);

    Set<Hobby> getHobbiesFromContact(Contact contact);
}
