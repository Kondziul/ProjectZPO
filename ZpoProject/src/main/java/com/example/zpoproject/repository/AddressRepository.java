package com.example.zpoproject.repository;

import com.example.zpoproject.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    // Tutaj można dodać dodatkowe metody zapytań specyficzne dla Address
}
