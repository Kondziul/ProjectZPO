package com.example.zpoproject.repository;

import com.example.zpoproject.entity.Hangar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangarRepository extends JpaRepository<Hangar, Long> {
    // Tutaj można dodać dodatkowe metody zapytań specyficzne dla Hangar
}
