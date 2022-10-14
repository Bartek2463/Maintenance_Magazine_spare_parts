package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.SparePart;
import com.example.maintenance_magazine_spare_parts.repository.SparePartRepository;
import lombok.AllArgsConstructor;
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

    public void deleteSparePartById(Long id){
        sparePartRepository.deleteById(id);
    }

}
