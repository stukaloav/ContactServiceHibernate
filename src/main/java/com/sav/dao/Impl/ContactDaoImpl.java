package com.sav.dao.Impl;

import com.sav.dao.ContactDao;
import com.sav.model.Contact;
import com.sav.model.Friendship;
import com.sav.model.Hobby;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class ContactDaoImpl implements ContactDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addContact(Contact contact) {
        if (contact == null){
            throw new IllegalArgumentException("argument should not be null");
        }
        sessionFactory.getCurrentSession().
                saveOrUpdate(contact);
    }

    @Override
    @Transactional
    public void deleteContact(Contact contact) {
        if (contact == null){
            throw new IllegalArgumentException("argument should not be null");
        }
            sessionFactory.getCurrentSession().delete(contact);

    }

    @Override
    @Transactional(readOnly = true)
    public Set<Contact> getAllContacts() {
        List<Contact> contacts = sessionFactory.getCurrentSession().
                createQuery("from Contact").list();
        Set<Contact> contactSet = new HashSet<Contact>();
        for (Contact contact: contacts){
            contactSet.add(contact);
        }
        return contactSet;

    }

    @Override
    @Transactional
    public Contact getContactById(long id){
            return (Contact) sessionFactory.
                    getCurrentSession().get(Contact.class, id);
    }

    @Override
    @Transactional
    public void addHobbyToContact(Contact contact, Hobby hobby){
        Long id = contact.getId();
        contact = (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
        contact.getHobbies().add(hobby);
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
    }

    @Override
    @Transactional
    public Long getIdFromContact(Contact contact){
        if (contact == null){
            return null;
        }
        Query query = sessionFactory.getCurrentSession().
                createQuery("select c from Contact c where c=:parameter");
        query.setParameter("parameter", contact);
        try {
            contact = (Contact) query.uniqueResult();
        }catch (HibernateException e){
            e: return null;
        }
        return contact.getId();
    }

    @Override
    @Transactional
    public void addFriendship(Contact first, Contact second){
        Long firstId = first.getId();
        Long secondId = second.getId();
        first = (Contact) sessionFactory.getCurrentSession().get(Contact.class, firstId);
        second = (Contact) sessionFactory.getCurrentSession().get(Contact.class, secondId);
        first.getFriends().add(second);
        sessionFactory.getCurrentSession().saveOrUpdate(first);
        sessionFactory.getCurrentSession().saveOrUpdate(second);
    }

    @Override
    @Transactional
    public List<Friendship> getAllFriends(){
        return sessionFactory.getCurrentSession().
                createQuery("from Friendship").list();
    }

}
