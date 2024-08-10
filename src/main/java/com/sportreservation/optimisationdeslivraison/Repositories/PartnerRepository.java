package com.sportreservation.optimisationdeslivraison.Repositories;

import com.sportreservation.optimisationdeslivraison.Entities.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface PartnerRepository extends JpaRepository<Partner, String> {

    List<Partner> findPartnerByPartnerId(String partnerId);
    List<Partner> findByPartnerIdContains(String searchName);
    Page<Partner> findByPartnerIdContaining(String partnerId, PageRequest pageable);



    



    /*@org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(pure = true)
    static List<Partner> findPartnerByLatitudeAfterAndLongitude() {
        return findPartnerByLatitudeAfterAndLongitude();
    }
*/



}
