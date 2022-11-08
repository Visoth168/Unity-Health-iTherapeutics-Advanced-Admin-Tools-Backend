package com.unityhealth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unityhealth.model.access;
import com.unityhealth.model.age;


@Repository
public interface ageRepo extends JpaRepository <age,Integer> {

}
