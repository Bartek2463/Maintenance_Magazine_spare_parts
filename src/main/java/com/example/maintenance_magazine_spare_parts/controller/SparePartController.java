package com.example.maintenance_magazine_spare_parts.controller;

import com.example.maintenance_magazine_spare_parts.model.SparePart;
import com.example.maintenance_magazine_spare_parts.service.SparePartServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/part")
public class SparePartController {

    private SparePartServices sparePartServices;


    @GetMapping
    public List<SparePart> getSpareParts(){
        return sparePartServices.getSpareParts();
    }

    @GetMapping("{id}")

     public  SparePart getSparePartById(@PathVariable Long id){
        return sparePartServices.getSparePartById(id);
    }

    @PostMapping
    public SparePart getSparePart( @RequestBody SparePart sparePart){
        return sparePartServices.addSparePart(sparePart);
    }

    @DeleteMapping("/{id}")
    public void deleteSparePart(@PathVariable Long id){
        sparePartServices.deleteSparePartById(id);
    }

}
