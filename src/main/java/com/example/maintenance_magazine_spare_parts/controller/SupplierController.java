package com.example.maintenance_magazine_spare_parts.controller;

import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import com.example.maintenance_magazine_spare_parts.service.SupplierPartServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
public class SupplierController {

    private SupplierPartServices supplierPartServices;


    @GetMapping("/suppliers")
    public String getSuppliers(Model model) {
        List<SupplierPart> suppliersParts = supplierPartServices.getSuppliersParts();
        model.addAttribute("supplier",suppliersParts);
        return "suppliers/suppliersList";
    }

    @GetMapping("{id}")
    public SupplierPart getSupplier(@PathVariable Long id) {
        return supplierPartServices.getSupplierById(id);
    }

    @GetMapping("/addSupplier")
    public String getAddSupplier() {
        return "suppliers/addNewSupplier";
    }


    @PostMapping("/addSupplier")
    public RedirectView addSupplier(@Valid SupplierPart supplierPart) {
        supplierPartServices.addSupplier(supplierPart);
        return new RedirectView("/suppliers");
    }

    @DeleteMapping
    public void delateSupplierByid(@PathVariable Long id) {
        supplierPartServices.deleteSupplierByid(id);
    }


}
