package com.sav.service.Impl;

import com.sav.dao.ContactDao;
import com.sav.model.Contact;
import com.sav.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactDao contactDao;

    @Override
    public void createContact(String firstName, String lastName, Date birthDate) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthDate(birthDate);
        contactDao.addContact(contact);
    }

    @Override
    public void deleteContact(Contact contact) {
        contactDao.deleteContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }
}
