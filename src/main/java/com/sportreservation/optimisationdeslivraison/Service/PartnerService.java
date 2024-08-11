package com.sportreservation.optimisationdeslivraison.Service;

import com.sportreservation.optimisationdeslivraison.Entities.Partner;
import com.sportreservation.optimisationdeslivraison.Repositories.PartnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    public Partner savePartner(Partner partner) {
        return partnerRepository.save(partner);
    }
//    public List<Partner> getAllPartners() {
//        return partnerRepository.findAll();
//    }

    public Page<Partner> getAllPartners(PageRequest pageRequest) {
        return partnerRepository.findAll(pageRequest);
    }

    public Partner getPartnerById(String id) {
        return partnerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Partner not found with ID: " + id));
    }

    public Partner addPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    public Partner updatePartner(String partnerId, Partner partnerDetails) {
        Partner partner = partnerRepository.findById(partnerId)
                .orElseThrow(() -> new RuntimeException("Partner not found with ID: " + partnerId));
        partner.setPartnerName(partnerDetails.getPartnerName());
        partner.setLatitude(partnerDetails.getLatitude());
        partner.setLongitude(partnerDetails.getLongitude());
        partner.setAmount(partnerDetails.getAmount());
        partner.setWeight(partnerDetails.getWeight());
        partner.setVolume(partnerDetails.getVolume());
        return partnerRepository.save(partner);
    }

    public void deletePartner(String partnerId) {
        Partner partner = partnerRepository.findById(partnerId)
                .orElseThrow(() -> new RuntimeException("Partner not found with ID: " + partnerId));
        partnerRepository.delete(partner);
    }
}
