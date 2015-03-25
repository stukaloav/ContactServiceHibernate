package com.sav.service;

import com.sav.model.Contact;

import java.util.Date;
import java.util.List;

public interface ContactService {
    void createContact(String firstName, String lastName, Date birthDate);
    void deleteContact(Contact contact);
    List<Contact> getAllContacts();
}
