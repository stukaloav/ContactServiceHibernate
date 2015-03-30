package com.sav.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="BIRTH_DATE")
    private Date birthDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name="CONTACT_HOBBIES"
            , joinColumns={@JoinColumn(name = "CONTACT_ID")}
            , inverseJoinColumns={@JoinColumn(name = "HOBBY_ID")})
    private List<Hobby> hobbies;

    public Contact() {
    }

    public Contact(String firstName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }
    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
