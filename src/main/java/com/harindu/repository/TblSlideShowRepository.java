package com.harindu.repository;

import com.harindu.model.TblSlideShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblSlideShowRepository extends JpaRepository<TblSlideShow, Long> {
    List<TblSlideShow> findAllByNameContainsIgnoreCase(String name);
}
