package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import com.example.maintenance_magazine_spare_parts.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class SupplierPartServices {

    private SupplierRepository supplierRepository;

    public List<SupplierPart> getSuppliersParts() {
        return supplierRepository.findAll();
    }

    public SupplierPart getSupplierById(Long id) {
        return supplierRepository
                .findById(id)
                .orElseThrow(()-> new NoSuchElementException("No exists"));
    }

    public SupplierPart addSupplier(SupplierPart supplierPart) {
        return supplierRepository.save(supplierPart);
    }

    public void deleteSupplierByid(Long id) {
        supplierRepository.deleteById(id);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB() {
//        addSupplier(new SupplierPart(1l, "Bosh", new HashSet<>()));
//        addSupplier(new SupplierPart(2l, "Froelish", new HashSet<>()));
//        addSupplier(new SupplierPart(3l, "Atlas Copco", new HashSet<>()));
//        addSupplier(new SupplierPart(4l, "RoYale", new HashSet<>()));
//        addSupplier(new SupplierPart(5l, "Transept", new HashSet<>()));
//        addSupplier(new SupplierPart(6l, "Okuma", new HashSet<>()));
//        addSupplier(new SupplierPart(7l, "Mazak", new HashSet<>()));
//    }


}
