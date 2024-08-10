//package com.sportreservation.optimisationdeslivraison.Web;
//
//import com.sportreservation.optimisationdeslivraison.Entities.Partner;
////import com.sportreservation.optimisationdeslivraison.Service.SpectralClusteringService;
//import com.sportreservation.optimisationdeslivraison.Service.SpectralClusteringService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/clustering")
//public class SpectralClusteringController {
//
//    @Autowired
//    private SpectralClusteringService clusteringService;
//
//    @GetMapping("/spectral")
//    public List<List<Partner>> getSpectralClusteringResults(@RequestParam int k) {
//        return clusteringService.applySpectralClustering(k);
//    }
//
////    @Autowired
//////    private SpectralClusteringService spectralClusteringService;
////    PartnerRepository repositoryLivraisonPoint;
////
////    @GetMapping(path="/index")
////    public String allPartners(Model model,
////                             @RequestParam(name = "page", defaultValue = "0") int page,
////                             @RequestParam(name = "size", defaultValue = "3") int size,
////                             @RequestParam(name="search", defaultValue = "") String searchName)
////    {
////
////        Page<Partner> pagePartner = Partner.findBypartnerNameContaining(PageRequest.of(page,size));
////
////        assert pagePartner != null;
////        int[] pages = new int[pagePartner.getTotalPages()];
////        for(int i=0; i<pages.length; i++)
////            pages[i]=i;
////
////
////        model.addAttribute("pagePartner",pagePartner.getContent());
////        model.addAttribute("tabPages", pages);
////        model.addAttribute("size", size);
////        model.addAttribute("currentPage", page);
////        model.addAttribute("searchName", searchName);
////        return "partner";
////    }
////    @GetMapping(path="/create")
////    public String createPartner(Model model){
////       Partner partner = new Partner();
////        model.addAttribute("Partner", partner);
////        return "formAddPartner";
////
////    }
////
////
////    @PostMapping(path = "/save")
////    public String savePartner(Model model, Partner s ,
////                             @RequestParam(name="currentPage", defaultValue = "0") int page,
////                             @RequestParam(name="size", defaultValue = "3") int size,
////                             @RequestParam(name="searchName", defaultValue = "") String search){
////        PartnerRepository.save(s);
////        return "redirect:/index?page="+page+"&size="+size+"&search="+search;
////    }
////
////
////
//////    @PostMapping("/spectral")
//////    public String performSpectralClustering(@RequestParam int k) {
//////        return spectralClusteringService.performSpectralClustering(k);
//////    }
//}
