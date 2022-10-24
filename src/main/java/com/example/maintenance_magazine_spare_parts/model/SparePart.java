package com.example.maintenance_magazine_spare_parts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SparePart {
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String catalogNumber;
    private String name;
    private Integer quantity;
    @ManyToOne
    private LocalizationPart localizationPart;
    @ManyToOne
    private SupplierPart supplierPart;

}
