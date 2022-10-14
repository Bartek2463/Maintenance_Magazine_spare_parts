package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.SparePart;
import com.example.maintenance_magazine_spare_parts.repository.SparePartRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@AllArgsConstructor
public class SparePartServices {

    private SparePartRepository sparePartRepository;


    public List<SparePart> getSpareParts(){
        return sparePartRepository.findAll();
    }




}
