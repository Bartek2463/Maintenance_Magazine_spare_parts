package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.SparePart;
import com.example.maintenance_magazine_spare_parts.repository.SparePartRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SparePartServices {

    private SparePartRepository sparePartRepository;


    public List<SparePart> getSpareParts() {
        return sparePartRepository.findAll();
    }

    public SparePart getSparePartById(Long id) {
        return sparePartRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("No exists Spare Part"));
    }

    public SparePart addSparePart(SparePart sparePart) {
        return sparePartRepository.save(sparePart);
    }

    public void deleteSparePartById(Long id) {
        sparePartRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDBSparePart() {
        addSparePart(new SparePart(1l, "3842992811", "Pas Transportowy GT 2/A", 28));
        addSparePart(new SparePart(2l, "MWR-25TA", "Klucz dynmometryczny łamany(reg)", 3));
        addSparePart(new SparePart(3l, "SKKD", "Moduł diodowy ELDC", 4));
        addSparePart(new SparePart(4l, "22126100", "Matrix Software protection system klucz usb", 2));
        addSparePart(new SparePart(5l, "SR-1000W", "Kamera SR", 2));
        addSparePart(new SparePart(6l, "660769", "Uszczelka kołnierzowa", 16));
    }

}
