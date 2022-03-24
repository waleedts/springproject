package com.harri.springproject.service;

import org.springframework.data.domain.Pageable;
import java.util.Map;

public interface CountryService {
    Map<String, Object> getAllCountries(Pageable pageable);
    Map<String, Object> getCountryByName(String countryName,Pageable pageable);
    Map<String, Object> getCountryByContinent(String continent,Pageable pageable );
}
