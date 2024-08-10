package com.sportreservation.optimisationdeslivraison.Repositories;

import com.sportreservation.optimisationdeslivraison.Entities.Partner;
import com.sportreservation.optimisationdeslivraison.Entities.Trucks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrucksRepository extends JpaRepository<Trucks, String> {
   /* List<Trucks> findTrucksByMatricule(String matricule);
    List<Trucks> findTrucksByMatriculeContaining(String matricule);
    Page<Trucks> findByPartnerIdContaining(String matricule, PageRequest pageable);*/


}
