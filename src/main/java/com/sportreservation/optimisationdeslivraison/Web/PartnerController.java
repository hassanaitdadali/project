package com.sportreservation.optimisationdeslivraison.Web;

import com.sportreservation.optimisationdeslivraison.Entities.Partner;
import com.sportreservation.optimisationdeslivraison.Repositories.PartnerRepository;
import com.sportreservation.optimisationdeslivraison.Service.PartnerService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@Controller
public class PartnerController {

    @Autowired
    PartnerRepository partnerRepository;



    @GetMapping(path="/index")
    public String allPartners(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "60") int size,
                              @RequestParam(name="search", defaultValue = "") String searchName)
    {

//        Page<Partner> pagePartners = PartnerRepository.findAll(PageRequest.of(page,size));

       Page<Partner> pagePartners = partnerRepository.findByPartnerIdContaining(searchName, PageRequest.of(page,size));
        int[] pages = new int[pagePartners.getTotalPages()];
        for(int i=0; i<pages.length; i++)
            pages[i]=i;

        model.addAttribute("pagePartner",pagePartners.getContent());
        model.addAttribute("tabPages", pages);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("searchName", searchName);
        return "partner";

    }

    @GetMapping(path="/create")
    public String createPartner(Model model){
        Partner partner = new Partner();
        model.addAttribute("partner", partner);
        return "formAddPartner";

    }
    @PostMapping("/save")
    public String savePartner(Partner partner, PartnerService partnerService,
                              @RequestParam(name = "currentPage", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "60") int size,
                              @RequestParam(name = "searchName", defaultValue = "") String searchName) {
        if (partner.getPartnerId() == null || partner.getPartnerId().isEmpty()) {
            partner.setPartnerId(UUID.randomUUID().toString());
        }
        partnerRepository.save(partner);
        return "redirect:/index?page=" + page + "&size=" + size + "&search=" + searchName;
    }


    @GetMapping(path = "/")
    public String homePage(){
        return "/menu";
    }

    @GetMapping(path="/delete")
    public String deletePartner(
            int page, int size, String searchName,
            @RequestParam(name="id") String id){
        partnerRepository.deleteById(String.valueOf(id));
        return "redirect:/index?page="+page+"&size="+size;

    }
    @GetMapping(path = "/edit")
    public String editPartner(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "60") int size,
                              @RequestParam(name = "searchName", defaultValue = "") String searchName,
                              @RequestParam(name = "id") String id) {
        Partner partner = partnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Partner not found with ID: " + id));

        System.out.println("Partner: " + partner);
        model.addAttribute("partner", partner);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("searchName", searchName);

        return "formEditPartner";
    }

//    @GetMapping(path = "/edit")
//    public String editPartner(Model model,
//                              @RequestParam int page,
//                              @RequestParam int size,
//                              @RequestParam String searchName,
//                              @RequestParam String id) {
//        Partner partner = partnerRepository.findById(id).orElseThrow(() -> new RuntimeException("Error: Partner not found"));
//
//        System.out.println("Partner: " + partner);
//        model.addAttribute("partner", partner);
//        model.addAttribute("size", size);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("searchName", searchName);
//
//        return "formEditPartner";
//    }


}