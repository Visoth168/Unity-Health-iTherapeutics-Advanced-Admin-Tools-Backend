package com.unityhealth.controller;

import com.unityhealth.model.TblSlideShow;
import com.unityhealth.service.TblSlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TblSlideShowController {

    // Injecting banner service class to call its methods to perform DB operations
    @Autowired private TblSlideShowService tblSlideShowService;

    // URL to add new banner it accepts post method and json as body
        @RequestMapping(path ="/add-new-slide", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addNewBanner(@RequestBody TblSlideShow tblSlideShow) {
        return tblSlideShowService.addNewSlideShow(tblSlideShow);
    }


    // URL to edit banner by id accepts put method and json as body
    @RequestMapping(path ="/edit-slide/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity editBanner(@PathVariable(value = "id") Long id, @RequestBody TblSlideShow banner) {
        return tblSlideShowService.editSlideSHowById(id,banner);
    }

    // URL to delete banner by id accepts delete method and parse id in params
    @RequestMapping(path ="/delete-banner/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteBanner(@PathVariable(value = "id") Long id) {
        return tblSlideShowService.deleteSlideShowById(id);
    }

    // URL to get banner by id accepts get method and parse id in params
    @RequestMapping(path ="/get-banner/{id}", method = RequestMethod.GET)
    public ResponseEntity getBannerById(@PathVariable(value = "id") Long id) {
        return tblSlideShowService.getSlideShowById(id);
    }

    // URL to search banner by first and last name it accepts get method
    @RequestMapping(path ="/search-banner/{name}", method = RequestMethod.GET)
    public ResponseEntity searchBannerByName(@PathVariable(value = "name") String name) {
        return tblSlideShowService.searchSlideShowByName(name);
    }


    // URL to get the list of all banners, accepts get method
    @RequestMapping(path ="/all-slideshows", method = RequestMethod.GET)
    public ResponseEntity getAllBanners() {
        return tblSlideShowService.getAllSlideShows();
    }



    // URL to get the list of all banners, accepts get method
    @RequestMapping(path ="/all-banners", method = RequestMethod.GET)
    public ResponseEntity getTest() {
        return tblSlideShowService.getAllBanner();
    }


    // URL to get the list of all banners, accepts get method
    @RequestMapping(path ="/activate-deactivate-banner/{id}/{status}", method = RequestMethod.GET)
    public ResponseEntity activateAndDeactivateBanner(@PathVariable(value = "id") Long id, @PathVariable(value = "status") String status) {
        return tblSlideShowService.activateAndDeactivateBanner(id,status);
    }
}
