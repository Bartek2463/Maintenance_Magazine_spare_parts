package com.example.maintenance_magazine_spare_parts.controller;

import com.example.maintenance_magazine_spare_parts.model.LocalizationPart;
import com.example.maintenance_magazine_spare_parts.service.LocalizationPartServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RestController
@RequestMapping("/local")
public class LocalizationController {

    private LocalizationPartServices localizationPartServices;

    @GetMapping
    public List<LocalizationPart> getLocation() {
        return localizationPartServices.getLocalizationParts();
    }

    @GetMapping("{id}")
    public LocalizationPart getLocalization(@PathVariable Long id) {
        return localizationPartServices.getLocalizationById(id);
    }

    @PostMapping
    public LocalizationPart addLocalizationPart(@RequestBody LocalizationPart localizationPart) {
        return localizationPartServices.addLocalization(localizationPart);
    }

    @DeleteMapping
    public void delateLocalizationPart(@PathVariable Long id) {
        localizationPartServices.deleteLocalization(id);
    }

}
