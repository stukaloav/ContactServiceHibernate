package com.sav.dao;

import com.sav.model.Contact;
import com.sav.model.ContactHobbies;
import com.sav.model.Hobby;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactDao {
    void addContact(Contact contact);
    void deleteContact(Contact contact);
    List<Contact> getAllContacts();

    @Transactional
    Contact getContactById(long id);

    @Transactional
    void addHobby(long id, Hobby hobby);

    @Transactional
    List<ContactHobbies> getHobbies();
}
