package com.sav.service;

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
    }
}
