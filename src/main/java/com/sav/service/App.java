package com.sav.service;

import com.sav.dao.ContactDao;
import com.sav.dao.HobbyDao;
import com.sav.model.Contact;
import com.sav.model.ContactHobbies;
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

        HobbyDao hobbyDao = context.getBean(HobbyDao.class);
        hobbyDao.addHobby(hobby);
        ContactDao contactDao = context.getBean(ContactDao.class);
        contactDao.addContact(contact);
        System.out.println(contactService.getAllHobbies());
        System.out.println(contactService.getAllContacts());
        contact = contactDao.getContactById(1l);
        hobby = hobbyDao.getHobbyById(1l);
        System.out.println(contact);
        System.out.println(hobby);
        contactDao.addHobby(1l, hobby);
        contactDao.addHobby(2l, hobby);
        System.out.println(contactDao.getHobbies());
    }
}
