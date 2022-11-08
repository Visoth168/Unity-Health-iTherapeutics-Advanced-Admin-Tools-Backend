package com.unityhealth.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unityhealth.model.access;

import com.unityhealth.repository.accessRepo;

@Service
public class accessService {
    @Autowired
    private accessRepo accessRepo;
    private Integer responseStatus = 400;

    public ResponseEntity getAllAccess(){
        List<access> accessList = accessRepo.findAll();

        if (accessList.size()>0){
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(accessList);
    }
}