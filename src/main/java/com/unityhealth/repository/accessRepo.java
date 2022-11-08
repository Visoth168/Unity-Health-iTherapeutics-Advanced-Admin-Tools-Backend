package com.unityhealth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unityhealth.model.access;

@Repository
public interface accessRepo extends JpaRepository <access,Integer> {

}