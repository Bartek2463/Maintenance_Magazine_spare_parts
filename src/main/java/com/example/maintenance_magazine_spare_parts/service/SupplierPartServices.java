package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import com.example.maintenance_magazine_spare_parts.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierPartServices {

    private SupplierRepository supplierRepository;

    public List<SupplierPart> getSuppliersParts() {
        return supplierRepository.findAll();
    }

    public SupplierPart getSupplierById(Long id) {
        return supplierRepository.findById(id).orElseThrow(null);
    }

    public SupplierPart addSupplier(SupplierPart supplierPart) {
        return supplierRepository.save(supplierPart);
    }

    public void deleteSupplierByid(Long id) {
        supplierRepository.deleteById(id);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB() {
//        addSupplier(new SupplierPart(1l, "Bosh"));
//        addSupplier(new SupplierPart(2l, "Froelish"));
//        addSupplier(new SupplierPart(3l, "Atlas Copco"));
//        addSupplier(new SupplierPart(4l, "RoYale"));
//        addSupplier(new SupplierPart(5l, "Transept"));
//        addSupplier(new SupplierPart(6l, "Okuma"));
//        addSupplier(new SupplierPart(7l, "Mazak"));
//    }


}
