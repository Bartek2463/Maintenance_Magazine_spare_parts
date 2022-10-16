package com.example.maintenance_magazine_spare_parts.controller;

import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import com.example.maintenance_magazine_spare_parts.service.SupplierPartServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@AllArgsConstructor
@Controller
public class SupplierController {

    private SupplierPartServices supplierPartServices;


    @GetMapping
    public List<SupplierPart> getSuppliers() {
        return supplierPartServices.getSuppliersParts();
    }

    @GetMapping("{id}")
    public SupplierPart getSupplier(@PathVariable Long id) {
        return supplierPartServices.getSupplierById(id);
    }

    @GetMapping("/add")
    public String getAddSupplier() {
        return "suppliers/addNewSupplier";
    }


    @PostMapping("/add")
    public RedirectView addSupplier(@RequestBody SupplierPart supplierPart) {
        supplierPartServices.addSupplier(supplierPart);
        return new RedirectView("/suppliers");
    }

    @DeleteMapping
    public void delateSupplierByid(@PathVariable Long id) {
        supplierPartServices.deleteSupplierByid(id);
    }


}
