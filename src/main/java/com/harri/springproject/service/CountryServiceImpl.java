package com.harri.springproject.service;

import com.harri.springproject.model.Country;
import com.harri.springproject.model.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class CountryServiceImpl implements CountryService{
    private final CountryRepository repository;
    @Autowired
    CountryServiceImpl(CountryRepository repository){
        this.repository = repository;
    }

    private Map<String, Object> preparePage(Page<Country> page) {
        Map<String, Object> response = new HashMap<>();
        response.put("Countries", page.getContent());
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());
        return response;
    }

    @Override
    public Map<String, Object> getAllCountries(Pageable pageable) {
        Page<Country> page=repository.findAll(pageable);
        return preparePage(page);
    }

    @Override
    public Map<String, Object> getCountryByName(String countryName,Pageable pageable) {
        Page<Country> page=repository.findByName(countryName,pageable);
        return preparePage(page);
    }

    @Override
    public Map<String, Object> getCountryByContinent(String continent, Pageable pageable) {
        Page<Country> page=repository.findByContinentName(continent,pageable);
        return preparePage(page);
    }
}
