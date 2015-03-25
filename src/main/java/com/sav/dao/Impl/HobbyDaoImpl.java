package com.sav.dao.Impl;

import com.sav.dao.HobbyDao;
import com.sav.model.Contact;
import com.sav.model.Hobby;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Set;

@Repository
public class HobbyDaoImpl implements HobbyDao{
    @Override
    public void addHobby(Hobby hobby) {

    }

    @Override
    public Set<Contact> getAllContactsWithHobby(Hobby hobby) {
        return null;
    }
}
