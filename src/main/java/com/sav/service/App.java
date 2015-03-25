package com.sav.service;

import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("app-context.xml");

        ContactService contactService = context.getBean(ContactService.class);
        System.out.println(contactService.getAllContacts());
    }
}
