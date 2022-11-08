package com.unityhealth.service;

import com.unityhealth.model.TblBanner;
import com.unityhealth.model.TblSlideShow;
import com.unityhealth.model.TblSlideShowBanner;
import com.unityhealth.repository.TblBannerRepository;
import com.unityhealth.repository.TblSlideShowBannerRepository;
import com.unityhealth.repository.TblSlideShowRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TblSlideShowBannerService {

    @Autowired private TblSlideShowBannerRepository tblSlideShowBannerRepository;

    @Autowired private TblSlideShowRepository tblSlideShowRepository;

    @Autowired private TblBannerRepository tblBannerRepository;

    private Integer responseStatus = 400;

    public ResponseEntity saveTblSlideShowBanner(String slideShowBoxes){
        JSONObject slideShowBoxesObj = new JSONObject(slideShowBoxes);

        JSONArray jsonArrayTblSlideShowBox = slideShowBoxesObj.getJSONArray("tblSlideShow");

        Set<TblSlideShow> tblSlideShows = new HashSet<>();

        TblBanner tblBanner = tblBannerRepository.findAll().get(0);
        //tblBanner.setSlideShows(tblSlideShows);

        tblBanner = tblBannerRepository.save(tblBanner);

        tblSlideShowRepository.deleteAll();

        if(jsonArrayTblSlideShowBox.length()>0){
            for(int i=0; i<jsonArrayTblSlideShowBox.length(); i++){
                JSONObject tblSlideShowObj = new JSONObject(jsonArrayTblSlideShowBox.get(i).toString());

                TblSlideShow tblSlideShow = new TblSlideShow();
                tblSlideShow.setName(tblSlideShowObj.getString("name"));
                tblSlideShow.setActive(tblSlideShowObj.getString("active"));
                tblSlideShow.setStartDate(LocalDate.parse(tblSlideShowObj.getString("startDate")));
                tblSlideShow.setEndDate(LocalDate.parse(tblSlideShowObj.getString("endDate")));

                tblSlideShows.add(tblSlideShow);
            }
        }

        tblBanner = tblBannerRepository.findAll().get(0);
        //tblBanner.setSlideShows(tblSlideShows);
        tblBannerRepository.save(tblBanner);

        JSONArray jsonArrayTblSlideShowBannerBox = slideShowBoxesObj.getJSONArray("tblSlideshowBanners");

        List<TblSlideShowBanner> tblSlideShowBanners = new ArrayList<>();

        tblSlideShowBannerRepository.deleteAll();

        if(jsonArrayTblSlideShowBannerBox.length()>0){
            for(int i=0; i<jsonArrayTblSlideShowBannerBox.length(); i++){
                JSONObject tblSlideShowBannerObj = new JSONObject(jsonArrayTblSlideShowBannerBox.get(i).toString());

                TblSlideShowBanner tblSlideShowBanner = new TblSlideShowBanner();
                //tblSlideShowBanner.setName(tblSlideShowBannerObj.getString("name"));
                //tblSlideShowBanner.setActive(tblSlideShowBannerObj.getString("active"));
                //tblSlideShowBanner.setStartDate(LocalDate.parse(tblSlideShowBannerObj.getString("startDate")));
                //tblSlideShowBanner.setEndDate(LocalDate.parse(tblSlideShowBannerObj.getString("endDate")));

                tblSlideShowBanners.add(tblSlideShowBanner);
            }
        }

        tblSlideShowBannerRepository.saveAll(tblSlideShowBanners);

        responseStatus = 200;

        return ResponseEntity.status(responseStatus).body(getAllSlideShowBanners().getBody());
    }

    //  It's returning all as list from db
    public ResponseEntity getAllSlideShowBanners(){
        List<TblSlideShowBanner> bannerList = tblSlideShowBannerRepository.findAll();

        if (bannerList.size()>0){
            responseStatus = 200;
        }else {
            responseStatus = 200;
        }
        return ResponseEntity.status(responseStatus).body(bannerList);
    }
    public ResponseEntity getAllSlideShowBannersbyslide(Long slideId){
        List<TblSlideShowBanner> bannerList = tblSlideShowBannerRepository.findAllBySlideId(slideId);

        if (bannerList.size()>0){
            responseStatus = 200;
        }else {
            responseStatus = 404;
        }
        return ResponseEntity.status(responseStatus).body(bannerList);
    }

}
