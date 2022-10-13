package com.example.maintenance_magazine_spare_parts.controller;

import com.example.maintenance_magazine_spare_parts.model.LocalizationPart;
import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import com.example.maintenance_magazine_spare_parts.service.LocalizationPartServices;
import com.example.maintenance_magazine_spare_parts.service.SupplierPartServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Controller
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierPartServices supplierPartServices;
    private LocalizationPartServices localizationPartServices;

    @GetMapping("/local")
public List<LocalizationPart> getLocation(){
        return localizationPartServices.getLocalizationParts();
    }

    @GetMapping
    public List<SupplierPart> getSuppliers() {
        return supplierPartServices.getSuppliersParts();
    }

    @GetMapping("{id}")
    public SupplierPart getSupplier(@PathVariable Long id) {
        return supplierPartServices.getSupplierById(id);
    }

    @PostMapping
    public SupplierPart addSupplier(@RequestBody SupplierPart supplierPart) {
        return supplierPartServices.addSupplier(supplierPart);
    }

    @DeleteMapping
    public void delateSupplierByid(@PathVariable Long id) {
        supplierPartServices.deleteSupplierByid(id);
    }


}
