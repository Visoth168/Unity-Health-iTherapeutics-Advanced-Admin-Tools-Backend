package com.harindu.controller;

import com.harindu.model.CompanyStaff;
import com.harindu.service.CompanyStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;


@RestController
@CrossOrigin("*")
public class CompanyStaffController {

    // Injecting company service class to call its methods to perform DB operations
    @Autowired private CompanyStaffService companyStaffService;

    // Home URL method to show welcome message
    @RequestMapping(path ="/", method = RequestMethod.GET)
    public ResponseEntity getWelcomeMessage() {
        LinkedHashMap welcomeResponse = new LinkedHashMap();
        welcomeResponse.put("message", "Welcome to API created with Spring Boot");
        return ResponseEntity.ok(welcomeResponse);
    }

    // URL to add new staff it accepts post method and json as body
    @RequestMapping(path ="/add-new-staff", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addNewStaff(@RequestBody CompanyStaff companyStaff) {
        return companyStaffService.addNewStaff(companyStaff);
    }


    // URL to edit staff by id accepts put method and json as body
    @RequestMapping(path ="/edit-staff/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity editStaff(@PathVariable(value = "id") Long id, @RequestBody CompanyStaff companyStaff) {
        return companyStaffService.editStaffById(id,companyStaff);
    }

    // URL to delete staff by id accepts delete method and parse id in params
    @RequestMapping(path ="/delete-staff/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStaff(@PathVariable(value = "id") Long id) {
        return companyStaffService.deleteStaffById(id);
    }

    // URL to get staff by id accepts get method and parse id in params
    @RequestMapping(path ="/get-staff/{id}", method = RequestMethod.GET)
    public ResponseEntity getStaffById(@PathVariable(value = "id") Long id) {
        return companyStaffService.getStaffById(id);
    }

    // URL to search staff by first and last name it accepts get method
    @RequestMapping(path ="/search-staff/{name}", method = RequestMethod.GET)
    public ResponseEntity searchStaffByFirstAndLastName(@PathVariable(value = "name") String name) {
        return companyStaffService.searchStaffByFirstAndLastName(name);
    }


    // URL to get the list of all staff, accepts get method
    @RequestMapping(path ="/all-staff", method = RequestMethod.GET)
    public ResponseEntity getAllStaff() {
        return companyStaffService.getAllStaff();
    }

}
