package mk.ukim.finki.eshopapp.service;


import mk.ukim.finki.eshopapp.model.Country;
import mk.ukim.finki.eshopapp.model.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country create(Long id, String name, String continent);
    List<Country> findAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(CountryDto country);
    Optional<Country> save(String name,String continent);
    Optional<Country> edit(Long id, String name, String continent);
    Optional<Country> edit(Long id, CountryDto country);
    void deleteById(Long id);
}