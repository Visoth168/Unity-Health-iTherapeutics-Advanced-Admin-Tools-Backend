package com.unityhealth.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unityhealth.model.age;
import com.unityhealth.model.title;
import com.unityhealth.repository.*;
@Service
public class titleService {
    @Autowired
    private titleRepo titleRepo;
    private Integer responseStatus=400;
    public ResponseEntity getAllTitle(){
        List<title> titleList = titleRepo.findAll();

        if (titleList.size()>0){
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(titleList);
    }
}