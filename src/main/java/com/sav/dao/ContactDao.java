package com.sav.dao;

import com.sav.model.Contact;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContactDao {
    void addContact(Contact contact);
    void deleteContact(Contact contact);
    List<Contact> getAllContacts();

    @Transactional
    Contact getContactById(long id);
}
