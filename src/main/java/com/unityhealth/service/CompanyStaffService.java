package com.unityhealth.service;

import com.unityhealth.model.CompanyStaff;
import com.unityhealth.repository.CompanyStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

// It's a service class which contains the main business logic of this backend
@Service
public class CompanyStaffService {

    // injecting JPA repository to call its build in method to perform CRUD
    @Autowired private CompanyStaffRepository companyStaffRepository;

    // creating a common integer variable to change http status code according to the condition
    private Integer responseStatus = 400;

    public ResponseEntity addNewStaff(CompanyStaff companyStaff){

        if (companyStaff != null){
            companyStaffRepository.save(companyStaff);
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(getAllStaff().getBody());
    }

    // method that updates the staff
    public ResponseEntity editStaffById(Long id, CompanyStaff companyStaffFromUI){

        // fetching old staff data from db
        CompanyStaff companyStaffFromDB = companyStaffRepository.findById(id).get();

       // Replacing the old staff data with the newly submitted data
        if (companyStaffFromUI !=null && companyStaffFromDB !=null){
            companyStaffFromDB.setCompany(companyStaffFromUI.getCompany());
            companyStaffFromDB.setAcl(companyStaffFromUI.getAcl());
            companyStaffFromDB.setAccountType(companyStaffFromUI.getAccountType());
            companyStaffFromDB.setFirstName(companyStaffFromUI.getFirstName());
            companyStaffFromDB.setLastName(companyStaffFromUI.getLastName());
            companyStaffFromDB.setEmail(companyStaffFromUI.getEmail());
            companyStaffFromDB.setTitle(companyStaffFromUI.getTitle());
            companyStaffFromDB.setAge(companyStaffFromUI.getAge());
            companyStaffFromDB.setPosition(companyStaffFromUI.getPosition());
            companyStaffFromDB.setCountry(companyStaffFromUI.getCountry());
            companyStaffFromDB.setState(companyStaffFromUI.getState());
            companyStaffFromDB.setSupplier(companyStaffFromUI.getSupplier());
            companyStaffRepository.save(companyStaffFromDB);
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(getAllStaff().getBody());
    }

    // it deletes the staff by id and catch the exception if id puts wrong
    public ResponseEntity deleteStaffById(Long id){
        try {
            companyStaffRepository.deleteById(id);
            responseStatus = 200;
            return ResponseEntity.status(responseStatus).body(getAllStaff().getBody());
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(404).body("No Record Found For ID: "+id);
        }
    }

    // this method find the staff by id and catch the exception if id puts wrong
    public ResponseEntity getStaffById(Long id){
        try {
            CompanyStaff companyStaff = companyStaffRepository.findById(id).get();
            responseStatus = 200;
            return ResponseEntity.status(responseStatus).body(companyStaff);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(404).body("No Record Found For ID: "+id);
        }
    }

    public ResponseEntity searchStaffByFirstAndLastName(String name){

        List<CompanyStaff> companyStaffList = companyStaffRepository.findAllByFirstNameContainsIgnoreCase(name);

        if (companyStaffList.size()>0){
            responseStatus = 200;
        }else if(companyStaffList.size()==0){
            companyStaffList = companyStaffRepository.findAllByLastNameContainsIgnoreCase(name);
            if (companyStaffList.size()>0){
                responseStatus = 200;
            }else {
                responseStatus = 404;
            }
        }
        return ResponseEntity.status(responseStatus).body(companyStaffList);
    }

    //  It's returning all staffs as list from db
    public ResponseEntity getAllStaff(){
        List<CompanyStaff> companyStaffList = companyStaffRepository.findAll();

        if (companyStaffList.size()>0){
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(companyStaffList);
    }

}
