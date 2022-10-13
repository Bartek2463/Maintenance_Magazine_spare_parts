package com.example.maintenance_magazine_spare_parts.repository;

import com.example.maintenance_magazine_spare_parts.model.LocalizationPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalizationRepository extends JpaRepository<LocalizationPart,Long> {
}
