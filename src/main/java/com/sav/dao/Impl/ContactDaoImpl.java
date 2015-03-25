package com.sav.dao.Impl;

import com.sav.dao.ContactDao;
import com.sav.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository    //in book @Repository("contactDao") also annotation @Transactional
public class ContactDaoImpl implements ContactDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().
                saveOrUpdate(contact);
        //log.info("Contact save with id: " + contact.getId());
    }


    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        sessionFactory.getCurrentSession().delete(contact);
        //log.info("Contact deleted with id: " + contact.getId());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().
                createQuery("from Contact").list();
    }
}
