package com.example.maintenance_magazine_spare_parts.repository;

import com.example.maintenance_magazine_spare_parts.model.SupplierPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierPart,Long> {
}
