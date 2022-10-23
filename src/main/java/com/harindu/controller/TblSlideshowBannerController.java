package com.harindu.controller;

import com.harindu.model.TblSlideShow;
import com.harindu.service.TblSlideShowBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TblSlideshowBannerController {

    @Autowired private TblSlideShowBannerService tblSlideShowBannerService;

    @RequestMapping(path ="/save-slideshow-banner", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addNewBanner(@RequestBody String slideShowBoxes) {
        return tblSlideShowBannerService.saveTblSlideShowBanner(slideShowBoxes);
    }

    @RequestMapping(path ="/all-slideshow-banners", method = RequestMethod.GET)
    public ResponseEntity getAllBanners() {
        return tblSlideShowBannerService.getAllSlideShowBanners();
    }


    @RequestMapping(path ="/all-slideshow-banners/{id}", method = RequestMethod.GET)
    public ResponseEntity editBanner(@PathVariable(value = "id") Long id) {
        return tblSlideShowBannerService.getAllSlideShowBannersbyslide(id);
    }

}
