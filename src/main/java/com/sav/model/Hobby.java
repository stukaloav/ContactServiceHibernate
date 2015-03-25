package com.sav.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HOBBY")
public class Hobby implements Serializable{

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "TITLE")
    private String title;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
