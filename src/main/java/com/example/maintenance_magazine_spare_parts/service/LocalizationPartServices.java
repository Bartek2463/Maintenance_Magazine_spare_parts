package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.LocalizationPart;import com.example.maintenance_magazine_spare_parts.model.SparePart;
import com.example.maintenance_magazine_spare_parts.repository.LocalizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class LocalizationPartServices {

    private LocalizationRepository localizationRepository;



    public List<LocalizationPart> getLocalizationParts() {
        return localizationRepository.findAll();
    }


    public LocalizationPart getLocalizationById(Long id) {
        return localizationRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not Exists Localization"));
    }


    public LocalizationPart addLocalization(LocalizationPart localizationPart) {
        return localizationRepository.save(localizationPart);
    }

    public void deleteLocalization(Long id) {
        localizationRepository.deleteById(id);
        System.out.println("Delete Localization id "+id );
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDBLocalization() {
//        addLocalization(new LocalizationPart(1l, "R4/3/3",new HashSet<>()));
//        addLocalization(new LocalizationPart(2l, "J2/1/6",new HashSet<>()));
//        addLocalization(new LocalizationPart(3l, "I4/2/2",new HashSet<>()));
//        addLocalization(new LocalizationPart(4l, "F2/1/3",new HashSet<>()));
//        addLocalization(new LocalizationPart(5l, "E2/3/5",new HashSet<>()));
//        addLocalization(new LocalizationPart(6l, "J3/1/6",new HashSet<>()));
//    }
//

}
