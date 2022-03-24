package com.harri.springproject.controller;

import com.harri.springproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/countries",method = RequestMethod.GET)
public class CountryController {
    CountryService service;
    Logger log=Logger.getAnonymousLogger();
    @Autowired
    public CountryController(CountryService service) {
        this.service = service;
    }

    @GetMapping("")
    public Map<String, Object> getAllCountries(@PageableDefault() final Pageable pageable,@RequestParam(required = false) String continent){
        Map<String, Object> response=continent==null?service.getAllCountries(pageable):service.getCountryByContinent(continent,pageable);
        if((Long)response.get("totalItems")==0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No Country With  Not Found"
            );
        }
        return response;
    }
    @GetMapping("/{countryName}")
    public Map<String, Object> getCountryByName(@PageableDefault() final Pageable pageable,@PathVariable String countryName){
        if((Long) service.getCountryByName(countryName, pageable).get("totalItems")==0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Country Not Found"
            );
        }
        return service.getCountryByName(countryName,pageable);
    }
}
