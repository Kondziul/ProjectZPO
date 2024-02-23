package com.example.zpoproject.repository;

import com.example.zpoproject.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    // Tutaj można dodać dodatkowe metody zapytań specyficzne dla Place
}
