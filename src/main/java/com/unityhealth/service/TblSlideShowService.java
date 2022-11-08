package com.unityhealth.service;

import com.unityhealth.model.TblBanner;
import com.unityhealth.model.TblSlideShow;
import com.unityhealth.model.TblSlideShowBanner;
import com.unityhealth.repository.TblBannerRepository;
import com.unityhealth.repository.TblSlideShowBannerRepository;
import com.unityhealth.repository.TblSlideShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class TblSlideShowService {

    // injecting JPA repository to call its build in method to perform CRUD
    @Autowired
    private TblSlideShowRepository tblSlideShowRepository;

    @Autowired TblBannerRepository tblBannerRepository;
    @Autowired private TblSlideShowBannerRepository tblSlideShowBannerRepository;

    // creating a common integer variable to change http status code according to the condition
    private Integer responseStatus = 400;

    public ResponseEntity addNewSlideShow(TblSlideShow slideShow){

        if (slideShow != null){
            // TblBanner tblBanner = tblBannerRepository.findAll().get(0);
            /// Set<TblSlideShow> tblSlideShows = tblBanner.getSlideShows();
           //  tblSlideShows.add(slideShow);
            // tblBanner.setSlideShows(tblSlideShows);
            TblSlideShow slide = new TblSlideShow();
            slide.setActive(slideShow.getActive());
            slide.setName(slideShow.getName());
            slide.setEndDate(slideShow.getEndDate());
            slide.setStartDate(slideShow.getStartDate());
            tblSlideShowRepository.save(slide);
            Set<TblBanner> banners = slideShow.getBanners();

            for (TblBanner b: banners) {
                TblSlideShowBanner tblSlideShowBanner = new TblSlideShowBanner();

                tblSlideShowBanner.setBanner_id(b.getId());
                tblSlideShowBanner.setSlide_id(slide.getId());

                tblSlideShowBannerRepository.save(tblSlideShowBanner);
            }
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(getAllSlideShows().getBody());
    }

    // method that updates the banner
    @Transactional
    public ResponseEntity editSlideSHowById(Long id, TblSlideShow bannerFromUI){

        // fetching old banner data from db
        TblSlideShow bannerFromDB = tblSlideShowRepository.findById(id).get();
        // delete banners for this slide show
        // insert the new ones
        // update the slideshow

        // Replacing the old banner data with the newly submitted data
        if (bannerFromUI !=null && bannerFromDB !=null){
            bannerFromDB.setName(bannerFromUI.getName());
            bannerFromDB.setActive(bannerFromUI.getActive());
            bannerFromDB.setStartDate(bannerFromUI.getStartDate());
            bannerFromDB.setEndDate(bannerFromUI.getEndDate());
            tblSlideShowRepository.save(bannerFromDB);
            tblSlideShowBannerRepository.deleteBySlideId(bannerFromDB.getId());
            Set<TblBanner> banners = bannerFromUI.getBanners();
            for (TblBanner b: banners) {
                TblSlideShowBanner tblSlideShowBanner = new TblSlideShowBanner();
                tblSlideShowBanner.setBanner_id(b.getId());
                tblSlideShowBanner.setSlide_id(bannerFromDB.getId());
                tblSlideShowBannerRepository.save(tblSlideShowBanner);
            }
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(getAllSlideShows().getBody());
    }

    // it deletes the banner by id and catch the exception if id puts wrong
    public ResponseEntity deleteSlideShowById(Long id){
        try {

            TblSlideShow tblSlideShow = tblSlideShowRepository.findById(id).get();

            TblBanner tblBanner = tblBannerRepository.findAll().get(0);
            // tblBanner.getSlideShows().remove(tblSlideShow);

            tblBannerRepository.save(tblBanner);

            tblSlideShowRepository.delete(tblSlideShow);

            responseStatus = 200;
            return ResponseEntity.status(responseStatus).body(getAllSlideShows().getBody());
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(404).body("No Record Found For ID: "+id);
        }
    }

    // this method find the banner by id and catch the exception if id puts wrong
    public ResponseEntity getSlideShowById(Long id){
        try {
            TblSlideShow banner = tblSlideShowRepository.findById(id).get();
            responseStatus = 200;
            return ResponseEntity.status(responseStatus).body(banner);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.status(404).body("No Record Found For ID: "+id);
        }
    }

    public ResponseEntity searchSlideShowByName(String name){

        List<TblSlideShow> bannerList = tblSlideShowRepository.findAllByNameContainsIgnoreCase(name);

        if (bannerList.size()>0){
            responseStatus = 200;
        }else if(bannerList.size()==0){
            bannerList = tblSlideShowRepository.findAllByNameContainsIgnoreCase(name);
            if (bannerList.size()>0){
                responseStatus = 200;
            }else {
                responseStatus = 404;
            }
        }
        return ResponseEntity.status(responseStatus).body(bannerList);
    }

    //  It's returning all as list from db
    public ResponseEntity getAllSlideShows(){
        List<TblSlideShow> bannerList = tblSlideShowRepository.findAll();

        if (bannerList.size()>0){
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(bannerList);
    }

    public ResponseEntity getAllBanner(){
        List<TblBanner> bannerList = tblBannerRepository.findAll();

        if (bannerList.size()>0){
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(bannerList);
    }

    public ResponseEntity activateAndDeactivateBanner(Long id, String status){
        // fetching old banner data from db
        TblSlideShow bannerFromDB = tblSlideShowRepository.findById(id).get();
            bannerFromDB.setActive(status);
            tblSlideShowRepository.save(bannerFromDB);
            responseStatus = 200;
            return ResponseEntity.status(responseStatus).body(getAllSlideShows().getBody());
    }
}
