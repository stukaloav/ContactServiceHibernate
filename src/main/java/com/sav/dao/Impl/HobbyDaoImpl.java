package com.sav.dao.Impl;

import com.sav.dao.HobbyDao;
import com.sav.model.Contact;
import com.sav.model.Hobby;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class HobbyDaoImpl implements HobbyDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addHobby(Hobby hobby) {
        sessionFactory.getCurrentSession().save(hobby);
    }

    @Override
    @Transactional
    public List<Contact> getAllContactsWithHobby(Hobby hobby) {
        return null;
    }

    @Override
    @Transactional
    public List<Hobby> getAllHobbies() {
        return sessionFactory.getCurrentSession().
                createQuery("from Hobby").list();
    }
}