package com.example.maintenance_magazine_spare_parts.service;

import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Slf4j
public class SupplierPartServices {

    private AtomicLong index = new AtomicLong(0);

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

    private  Long nextIdx(){
        return index.incrementAndGet();
    }

    public List<SupplierPart> getSuppliersParts(){
        return suppliersParts;
    }

    public SupplierPart getSupplierById (Long id){
        return suppliersParts.get(id.intValue()-1);
    }
    public SupplierPart addSupplier(SupplierPart supplierPart){
       suppliersParts.add(supplierPart);
       return supplierPart;
    }




}
