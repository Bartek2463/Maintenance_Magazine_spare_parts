package com.example.maintenance_magazine_spare_parts.dto;

import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import lombok.Value;

@Value
public class SupplierPartDTO {

    private Long id;
    private String supplier;


    public SupplierPart toSupplierPart(Long id){
        return new SupplierPart(id,supplier);
    }

}
