package com.example.zpoproject.repository;

import com.example.zpoproject.entity.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
    // Tutaj można dodać dodatkowe metody zapytań specyficzne dla Airplane
}
