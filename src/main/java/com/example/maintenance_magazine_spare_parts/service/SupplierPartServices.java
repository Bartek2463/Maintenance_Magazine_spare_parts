package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.dto.SupplierPartDTO;
import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import com.example.maintenance_magazine_spare_parts.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@AllArgsConstructor
public class SupplierPartServices {

    private SupplierRepository supplierRepository;



    private List<SupplierPart> suppliersParts = new LinkedList<>(){
        {

            add(new SupplierPart(nextIdx(),"Bosh"));
            add(new SupplierPart(nextIdx(),"Froelish"));
            add(new SupplierPart(nextIdx(),"Atlas Copco"));
            add(new SupplierPart(nextIdx(),"RoYale"));
            add(new SupplierPart(nextIdx(),"Transept"));
            add(new SupplierPart(nextIdx(),"Okuma"));
            add(new SupplierPart(nextIdx(),"Mazak"));
        }
    };

    public List<SupplierPart> getSuppliersParts(){
        return supplierRepository.findAll();
    }

    public SupplierPart getSupplierById (Long id){
        return supplierRepository.findById(id).orElseThrow(null);
    }
    public SupplierPart addSupplier(SupplierPart supplierPart){
        return  supplierRepository.save(supplierPart);
    }

    





}
