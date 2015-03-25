package com.sav.service;

import com.sav.dao.ContactDao;
import com.sav.model.Contact;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");

        ContactService contactService = context.getBean(ContactService.class);
        System.out.println(contactService.getAllContacts());
        Date date = new Date(86, 1, 1);
        contactService.createContact("Sasha", "Stukalo", date);
        System.out.println(contactService.getAllContacts());
        Contact contact = new Contact();
        contact.setFirstName("Sasha");
        contact.setLastName("Stukalo");
        contact.setBirthDate(date);
        contactService.deleteContact(contact);
        System.out.println(contactService.getAllContacts());
    }
}
