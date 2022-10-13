package com.example.maintenance_magazine_spare_parts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SparePart {

    private Long id;
    private String catalogNumber;
    private String name;
    private Integer min;
    private String localization;
    private String supplier;

}
