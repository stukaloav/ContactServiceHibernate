package com.sav.dao.Impl;

import com.sav.dao.ContactDao;
import com.sav.dao.HobbyDao;
import com.sav.model.Contact;
import com.sav.model.ContactHobbies;
import com.sav.model.Hobby;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Transactional(readOnly = true)
    public List<Hobby> getAllHobbies() {
        return sessionFactory.getCurrentSession().
                createQuery("from Hobby").list();
    }

    @Override
    @Transactional
    public Hobby getHobbyById(long id) {
        return (Hobby) sessionFactory.getCurrentSession().get(Hobby.class, id);
    }

    @Override
    @Transactional
    public Set<Contact> getAllContactsWithHobby() {
        Set<Long> contactsId = getIdOfContactWithHobbies();
        if (contactsId == null){
            return null;
        }
        Set<Contact> contacts = new HashSet<Contact>();
        for (Long id: contactsId){
            contacts.add(getContactById(id));
        }
        return contacts;
    }

    @Transactional
    private List<ContactHobbies> getContactHobbies(){
        return sessionFactory.getCurrentSession().createQuery("from ContactHobbies").list();
    }

    @Transactional
    private Set<Long> getIdOfContactWithHobbies(){
        List<ContactHobbies> contactHobbiesList = getContactHobbies();
        if (contactHobbiesList.isEmpty()){
            return null;
        }
        Set<Long> idOfContactWithHobbies = new HashSet<Long>();
        for (ContactHobbies item: contactHobbiesList){
            idOfContactWithHobbies.add(item.getContactId());
        }
        return idOfContactWithHobbies;
    }

    @Transactional
    private Contact getContactById(long id){
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }
}
