package com.example.maintenance_magazine_spare_parts.controller;

import com.example.maintenance_magazine_spare_parts.model.LocalizationPart;
import com.example.maintenance_magazine_spare_parts.model.SparePart;
import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import com.example.maintenance_magazine_spare_parts.service.LocalizationPartServices;
import com.example.maintenance_magazine_spare_parts.service.SparePartServices;
import com.example.maintenance_magazine_spare_parts.service.SupplierPartServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@AllArgsConstructor
public class SparePartController {

    private SparePartServices sparePartServices;
    private LocalizationPartServices localizationPartServices;
    private SupplierPartServices supplierPartServices;


    @GetMapping("/spareParts")
    public String getSpareParts(Model model){
        List<SparePart> spareParts = sparePartServices.getSpareParts();
        model.addAttribute("spare",spareParts);
        return "parts/partList";
    }

    @GetMapping("/addPart")
    public String getAddPart(Model model){
        List<LocalizationPart> localizationParts = localizationPartServices.getLocalizationParts();
        List<SupplierPart> suppliersParts = supplierPartServices.getSuppliersParts();
        model.addAttribute("localization",localizationParts);
        model.addAttribute("supplier",suppliersParts);
        return "parts/addPart";
    }

    @PostMapping("/addPart")
    public RedirectView getSparePart(SparePart sparePart){
        sparePartServices.addSparePart(sparePart);
        return new RedirectView("/spareParts");
    }

    @GetMapping("{id}")

     public  SparePart getSparePartById(@PathVariable Long id){
        return sparePartServices.getSparePartById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSparePart(@PathVariable Long id){
        sparePartServices.deleteSparePartById(id);
    }

}
