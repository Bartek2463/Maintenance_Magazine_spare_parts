package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.LocalizationPart;
import com.example.maintenance_magazine_spare_parts.repository.LocalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class LocalizationPartServices {

    private LocalizationRepository localizationRepository;



    public List<LocalizationPart> getLocalizationParts(){
        return localizationRepository.findAll();
    }


    public LocalizationPart getLocalizationById(Long id){
        return localizationRepository
                .findById(id)
                .orElseThrow(()->new NoSuchElementException("Not Exists Localization"));
    }


    public LocalizationPart addLocalization(LocalizationPart localizationPart){
        return localizationRepository.save(localizationPart);
    }

    public void deleteLocalization(Long id){
        localizationRepository.deleteById(id);
    }



}
