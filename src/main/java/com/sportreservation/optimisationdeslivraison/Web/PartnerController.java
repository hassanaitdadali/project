package com.sportreservation.optimisationdeslivraison.Web;

import com.sportreservation.optimisationdeslivraison.Entities.Partner;
import com.sportreservation.optimisationdeslivraison.Service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping("/index")
    public String allPartners(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "60") int size,
                              @RequestParam(name = "search", defaultValue = "") String searchName) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Partner> pagePartners = partnerService.getAllPartners(pageRequest);
        int[] pages = new int[pagePartners.getTotalPages()];
        for (int i = 0; i < pages.length; i++)
            pages[i] = i;

        model.addAttribute("pagePartner", pagePartners.getContent());
        model.addAttribute("tabPages", pages);
        model.addAttribute("size", size);
        model.addAttribute("currentPage", page);
        model.addAttribute("searchName", searchName);
        return "partner";
    }
    @PostMapping("/createPartner")
    public String createPartner(@RequestParam String partnerName,
                                @RequestParam double latitude,
                                @RequestParam double longitude,
                                @RequestParam double amount,
                                @RequestParam double weight,
                                @RequestParam float volume,
                                Model model) {
        Partner partner = new Partner();
        partner.setPartnerName(partnerName);
        partner.setLatitude(latitude);
        partner.setLongitude(longitude);
        partner.setAmount(amount);
        partner.setWeight(weight);
        partner.setVolume(volume);

        partnerService.savePartner(partner);

        model.addAttribute("message", "Partner saved successfully!");
        return "formAddPartner";
    }

    /*@GetMapping("/create")
    public String createPartner(Model model) {
        model.addAttribute("partner", new Partner());
        return "formAddPartner";
    }*/
    @PostMapping("/save")
    public String savePartner(Partner partner,
                              @RequestParam(name = "currentPage", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "60") int size,
                              @RequestParam(name = "searchName", defaultValue = "") String searchName) {
        if (partner.getPartnerId() == null || partner.getPartnerId().isEmpty()) {
            partner.setPartnerId(UUID.randomUUID().toString());
        }
        partnerService.addPartner(partner);
        return "redirect:/index?page=" + page + "&size=" + size + "&search=" + searchName;
    }



    @GetMapping("/")
    public String homePage() {
        return "menu";
    }

    @GetMapping("/delete")
    public String deletePartner(@RequestParam(name = "id") String id,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "60") int size) {
        partnerService.deletePartner(id);
        return "redirect:/index?page=" + page + "&size=" + size;
    }

    @GetMapping("/edit")
    public String editPartner(Model model,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "60") int size,
                              @RequestParam(name = "searchName", defaultValue = "") String searchName,
                              @RequestParam(name = "id") String id) {
        // Get Partner by ID
        Partner partner = partnerService.getPartnerById(id);
        partnerService.updatePartner(id,partner);

        // Add Partner to model
        model.addAttribute("partner", partner);

        // Add pagination and search parameters to model if needed
        model.addAttribute("page", page);
        model.addAttribute("size", size);
        model.addAttribute("searchName", searchName);

        // Return the name of the Thymeleaf template
        return "formEditPartner";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partner> getPartnerById(@PathVariable("id") String id) {
        Partner partner = partnerService.getPartnerById(id);
        return ResponseEntity.ok(partner);
    }
}
