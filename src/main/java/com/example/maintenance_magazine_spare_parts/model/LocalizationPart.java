package com.example.maintenance_magazine_spare_parts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocalizationPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String localization;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "localizationPart")
    private Set<SparePart> spareParts = new HashSet<>();

}
