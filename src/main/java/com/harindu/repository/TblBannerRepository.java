package com.harindu.repository;

import com.harindu.model.TblBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblBannerRepository extends JpaRepository<TblBanner, Long> {}
