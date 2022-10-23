package com.harindu.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TblSlideShowBanner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    Long slideId;
    Long banner_id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(Long banner_id) {
        this.banner_id = banner_id;
    }

    public Long getSlide_id() {
        return slideId;
    }

    public void setSlide_id(Long slide_id) {
        this.slideId = slide_id;
    }
}
