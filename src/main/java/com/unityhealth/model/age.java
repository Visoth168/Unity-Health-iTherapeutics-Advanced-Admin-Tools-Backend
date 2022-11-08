package com.unityhealth.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity 
@Table(name = "age")
public class age {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    String Age_range;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAge_range() {
        return Age_range;
    }

    public void setAge_range(String age_range) {
        Age_range = age_range;
    }
}