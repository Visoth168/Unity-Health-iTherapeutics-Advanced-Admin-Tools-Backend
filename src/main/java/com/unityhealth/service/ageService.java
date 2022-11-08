package com.unityhealth.service;
import com.unityhealth.model.age;

import com.unityhealth.repository.ageRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ageService {
    @Autowired
    private ageRepo ageRepo;
    private Integer responseStatus = 400;

    public ResponseEntity getAllAge(){
        List<age> ageList = ageRepo.findAll();

        if (ageList.size()>0){
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(ageList);
    }
}