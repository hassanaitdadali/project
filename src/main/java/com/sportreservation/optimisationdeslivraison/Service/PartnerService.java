package com.sportreservation.optimisationdeslivraison.Service;

import com.sportreservation.optimisationdeslivraison.Entities.Partner;
import com.sportreservation.optimisationdeslivraison.Repositories.PartnerRepository;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@Resource
@Service
public class PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    public Optional<Partner> getPartnerById(String partnerId) {
        return partnerRepository.findById(partnerId);
    }

    public Partner addPartner(Partner partner) {
        return partnerRepository.save(partner);
    }

    public Partner updatePartner(String partnerId, Partner partnerDetails) {
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(() -> new RuntimeException("Partner not found"));
        partner.setPartnerName(partnerDetails.getPartnerName());
        partner.setLatitude(partnerDetails.getLatitude());
        partner.setLongitude(partnerDetails.getLongitude());
        partner.setAmount(partnerDetails.getAmount());
        partner.setWeight(partnerDetails.getWeight());
        partner.setVolume(partnerDetails.getVolume());
        return partnerRepository.save(partner);
    }

    public void deletePartner(String partnerId) {
        Partner partner = partnerRepository.findById(partnerId).orElseThrow(() -> new RuntimeException("Partner not found"));
        partnerRepository.delete(partner);
    }
}
