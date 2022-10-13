package com.example.maintenance_magazine_spare_parts.controller;

import com.example.maintenance_magazine_spare_parts.dto.SupplierPartDTO;
import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import com.example.maintenance_magazine_spare_parts.service.SupplierPartServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierPartServices supplierPartServices;


    @GetMapping
    public List<SupplierPart> getSuppliers() {
        return supplierPartServices.getSuppliersParts();
    }

    @GetMapping("{id}")
    public SupplierPart getSupplier(@PathVariable Long id){
        return supplierPartServices.getSupplierById(id);
    }

    @PostMapping
    public SupplierPart addSupplier(@RequestBody SupplierPartDTO supplierPartDTO){
        return supplierPartServices.addSupplier(supplierPartDTO);
    }


}
