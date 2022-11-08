package com.unityhealth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unityhealth.model.title;
@Repository
public interface titleRepo extends JpaRepository<title,Integer> {

}