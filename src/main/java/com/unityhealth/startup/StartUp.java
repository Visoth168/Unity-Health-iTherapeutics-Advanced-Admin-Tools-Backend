package com.unityhealth.startup;

import com.unityhealth.model.TblBanner;
import com.unityhealth.model.TblSlideShow;
import com.unityhealth.model.CompanyStaff;
import com.unityhealth.model.TblSlideShowBanner;
import com.unityhealth.repository.TblBannerRepository;
import com.unityhealth.repository.CompanyStaffRepository;
import com.unityhealth.repository.TblSlideShowBannerRepository;
import com.unityhealth.repository.TblSlideShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

//@Component
//public class StartUp implements CommandLineRunner {
//
//    // injecting JPA repository to call its build in method to perform CRUD
//   @Autowired private CompanyStaffRepository companyStaffRepository;
//
//    // injecting JPA repository to call its build in method to perform CRUD
//   @Autowired private TblBannerRepository tblBannerRepository;
//    @Autowired private TblSlideShowRepository tblSlideShowRepository;
//
//    @Autowired private TblSlideShowBannerRepository tblSlideShowBannerRepository;


//    @Override
//    public void run(String... args) throws Exception {
//
//        // creating a test staff account. it will auto create and save in DB when application starts
//        CompanyStaff companyStaff = new CompanyStaff();
//        companyStaff.setCompany("Test Acc");
//        companyStaff.setAcl(1);
//        companyStaff.setAccountType("Developer");
//        companyStaff.setFirstName("Harindu");
//        companyStaff.setLastName("Kalupahana");
//        companyStaff.setEmail("S1496087@melbournepolytechnic.com");
//
//        companyStaffRepository.save(companyStaff);
//
//        CompanyStaff companyStaff2 = new CompanyStaff();
//        companyStaff.setCompany("Test Acc");
//        companyStaff.setAcl(1);
//        companyStaff.setAccountType("Developer");
//        companyStaff.setFirstName("Biraj");
//        companyStaff.setLastName("Visoth");
//        companyStaff.setEmail("S1496085@melbournepolytechnic.com");
//
//        companyStaffRepository.save(companyStaff2);
//        // create Banner
//
//        TblBanner tblBanner = new TblBanner();

        // Set<TblSlideShow> tblSlideShows = tblBanner.getSlideShows();


//        TblSlideShow slideShow1 = new TblSlideShow();
//        slideShow1.setName("Baby and Child Health");
//        slideShow1.setActive("Yes");
//        slideShow1.setStartDate(LocalDate.now().minusDays(14));
//        slideShow1.setEndDate(LocalDate.now().plusDays(7));
//        tblSlideShowRepository.save(slideShow1);
//        // tblSlideShows.add(slideShow1);
//
//        TblSlideShow slideShow2 = new TblSlideShow();
//        slideShow2.setName("Coolest Areas");
//        slideShow2.setActive("Yes");
//        slideShow2.setStartDate(LocalDate.now().minusDays(14));
//        slideShow2.setEndDate(LocalDate.now().plusDays(7));
//        tblSlideShowRepository.save(slideShow2);
//
//        //tblSlideShows.add(slideShow2);
//
//        TblSlideShow slideShow3 = new TblSlideShow();
//        slideShow3.setName("Weather Conditions");
//        slideShow3.setActive("Yes");
//        slideShow3.setStartDate(LocalDate.now().minusDays(14));
//        slideShow3.setEndDate(LocalDate.now().plusDays(7));
//        tblSlideShowRepository.save(slideShow3);
//
//        //tblSlideShows.add(slideShow3);
//
//        TblSlideShow slideShow4 = new TblSlideShow();
//        slideShow4.setName("Climate Change Impact on People");
//        slideShow4.setActive("No");
//        slideShow4.setStartDate(LocalDate.now().minusDays(14));
//        slideShow4.setEndDate(LocalDate.now().plusDays(7));
//        tblSlideShowRepository.save(slideShow4);
//
//        // tblSlideShows.add(slideShow4);
//
//        TblSlideShow slideShow5 = new TblSlideShow();
//        slideShow5.setName("Digital Skills Awareness");
//        slideShow5.setActive("No");
//        slideShow5.setStartDate(LocalDate.now().minusDays(14));
//        slideShow5.setEndDate(LocalDate.now().plusDays(7));
//        tblSlideShowRepository.save(slideShow5);
//
//        // tblSlideShows.add(slideShow5);
//
//        TblSlideShow slideShow6 = new TblSlideShow();
//        slideShow6.setName("Education Is Very Important For All");
//        slideShow6.setActive("No");
//        slideShow6.setStartDate(LocalDate.now().minusDays(14));
//        slideShow6.setEndDate(LocalDate.now().plusDays(7));
//        tblSlideShowRepository.save(slideShow6);
//
//        // tblSlideShows.add(slideShow6);
//
//        //tblBanner.setSlideShows(tblSlideShows);
//        TblBanner banner1 = new TblBanner();
//        banner1.setName("Banner 1");
//        banner1.setStartDate(LocalDate.now().minusDays(14));
//        banner1.setEndDate(LocalDate.now().plusDays(7));
//
//        TblBanner banner2 = new TblBanner();
//        banner2.setName("Banner 2");
//        banner2.setStartDate(LocalDate.now().minusDays(14));
//        banner2.setEndDate(LocalDate.now().plusDays(7));
//
//
//        tblBannerRepository.save(banner1);
//        tblBannerRepository.save(banner2);
//
//
//        TblSlideShowBanner tblSlideShowBanner = new TblSlideShowBanner();
//
//        tblSlideShowBanner.setBanner_id(banner1.getId());
//        tblSlideShowBanner.setSlide_id(slideShow1.getId());
//
//        tblSlideShowBannerRepository.save(tblSlideShowBanner);





//    }
//}
