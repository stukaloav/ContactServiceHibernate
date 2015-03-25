package com.sav.service.Impl;

import com.sav.dao.ContactDao;
import com.sav.dao.HobbyDao;
import com.sav.model.Contact;
import com.sav.model.Hobby;
import com.sav.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ContactServiceImpl implements ContactService{

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private HobbyDao hobbyDao;

    @Override
    public void createContact(String firstName, String lastName, Date birthDate) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthDate(birthDate);
        contactDao.addContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactDao.getAllContacts();
    }

    @Override
    public void addHobby(String title, String description) {
        Hobby hobby = new Hobby();
        hobby.setTitle(title);
        hobby.setDescription(description);
        hobbyDao.addHobby(hobby);
    }

    @Override
    public List<Hobby> getAllHobbies(){
        return hobbyDao.getAllHobbies();}
}
