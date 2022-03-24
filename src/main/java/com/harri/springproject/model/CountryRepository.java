package com.harri.springproject.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, char[]> {
    Page<Country> findByName(String name,Pageable pageable);
    Page<Country> findByContinentName(String continent,Pageable pageable);
}
