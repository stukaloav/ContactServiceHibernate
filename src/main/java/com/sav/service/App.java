package com.sav.service;

import com.sav.dao.ContactDao;
import com.sav.dao.HobbyDao;
import com.sav.model.Contact;
import com.sav.model.Hobby;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");

        ContactService contactService = context.getBean(ContactService.class);
        System.out.println(contactService.getAllContacts());
        contactService.createContact("Sasha", "Stukalo", new Date(86, 1, 1));
        System.out.println(contactService.getAllContacts());
        System.out.println(contactService.getAllHobbies());
        contactService.addHobby("football", "favourite team is Dnipro");
        System.out.println(contactService.getAllHobbies());
        System.out.println(contactService.getAllPlaces());
        contactService.addPlace("Lviv", 0.21, 0.15);
        System.out.println(contactService.getAllPlaces());

        Contact contact = new Contact("Jane", "Patric", new Date(23, 1, 4));
        Hobby hobby = new Hobby("Movies", "Detective");
        contactService.addContact(contact);
        contactService.addHobby(hobby);
        System.out.println(contactService.getAllHobbies());
        System.out.println(contactService.getAllContacts());
        Contact contact1 = contactService.getContactById(1l);
        Contact contact2 = contactService.getContactById(2l);
        System.out.println(contact1);
        System.out.println(contact2);
        contactService.addHobbyToContact(contact1, hobby);
        System.out.println(contactService.getIdFromContact(contact1));
        Contact contact3 = new Contact("Jane", "Patric", new Date(25, 1, 4));
        contactService.addContact(contact3);
        System.out.println(contactService.getAllContacts());
        System.out.println(contactService.getContactById(8));
        contactService.addFriendship(contact1, contact2);
        System.out.println(contactService.getAllFriendPairs());
    }
}
