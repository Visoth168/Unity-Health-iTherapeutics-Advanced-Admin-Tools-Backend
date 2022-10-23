package com.harindu.repository;

import com.harindu.model.CompanyStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyStaffRepository extends JpaRepository<CompanyStaff, Long> {
    List<CompanyStaff> findAllByFirstNameContainsIgnoreCase(String firstName);
    List<CompanyStaff> findAllByLastNameContainsIgnoreCase(String lastName);
}
