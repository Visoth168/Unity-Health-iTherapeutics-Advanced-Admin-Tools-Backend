package com.unityhealth.repository;

import com.unityhealth.model.TblSlideShowBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblSlideShowBannerRepository extends JpaRepository<TblSlideShowBanner, Long> {
    Long deleteBySlideId(Long id);
    List<TblSlideShowBanner> findAllBySlideId(Long id);
}
