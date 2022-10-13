package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.LocalizationPart;
import com.example.maintenance_magazine_spare_parts.repository.LocalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocalizationPartServices {

    private LocalizationRepository localizationRepository;



    public List<LocalizationPart> getLocalizationParts(){
        return localizationRepository.findAll();
    }




}
