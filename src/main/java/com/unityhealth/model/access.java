package com.unityhealth.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity 
@Table(name = "access_level")
public class access {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    String a_levels;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getA_levels() {
        return a_levels;
    }

    public void setA_levels(String a_levels) {
        this.a_levels = a_levels;
    }
}