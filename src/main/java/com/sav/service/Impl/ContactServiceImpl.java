package com.sav.service.Impl;

import com.sav.model.*;
import com.sav.dao.*;
import com.sav.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;
    @Autowired
    private HobbyDao hobbyDao;
    @Autowired
    private PlaceDao placeDao;

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

    @Override
    public void addPlace(String title, double longitude, double latitude) {
        Place place = new Place();
        place.setTitle(title);
        place.setLongitude(longitude);
        place.setLatitude(latitude);
        placeDao.addPlace(place);
    }
    @Override
    public List<Place> getAllPlaces() {
        return placeDao.getAllPlaces();
    }
}
