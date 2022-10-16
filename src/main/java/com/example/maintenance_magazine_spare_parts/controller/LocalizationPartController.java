package com.example.maintenance_magazine_spare_parts.controller;

import com.example.maintenance_magazine_spare_parts.model.LocalizationPart;
import com.example.maintenance_magazine_spare_parts.service.LocalizationPartServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Controller
public class LocalizationPartController {

    private LocalizationPartServices localizationPartServices;


    @GetMapping("/localizations")
    public String getLocalizations(Model model) {

        List<LocalizationPart> localizationParts = localizationPartServices.getLocalizationParts();
        model.addAttribute("localization", localizationParts);
        return "localizations/localizationList";
    }


    @GetMapping("/addLocalization")
    public String getAddLocalization() {
        return "localizations/addNewLocalization";
    }

    @PostMapping("/addLocalization")
    public RedirectView addLocalization(@Valid LocalizationPart localizationPart) {
        localizationPartServices.addLocalization(localizationPart);
        return new RedirectView("/localizations");
    }

    @GetMapping("/editLocalization/{id}")
    public String getEditLocalization(@PathVariable Long id, Model model) {
        LocalizationPart localizationById = localizationPartServices.getLocalizationById(id);
        model.addAttribute("localization", localizationById);
        return "localizations/editLocalization";
    }

    @PostMapping("/editLozalization/{id}")
    public RedirectView postEditLocalization(@Valid LocalizationPart localizationPart) {
        localizationPartServices.addLocalization(localizationPart);
        return new RedirectView("/localizations");
    }

    @PostMapping("/delete/{id}")
    public RedirectView deleteLozalization(@PathVariable Long id) {
        localizationPartServices.deleteLocalization(id);
        return new RedirectView("/localizations");
    }


}
