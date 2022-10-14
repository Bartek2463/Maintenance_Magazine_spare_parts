package com.example.maintenance_magazine_spare_parts.repository;

import com.example.maintenance_magazine_spare_parts.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartRepository extends JpaRepository<SparePart,Long> {
}
