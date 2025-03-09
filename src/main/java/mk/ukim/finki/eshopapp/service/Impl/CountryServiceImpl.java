package mk.ukim.finki.eshopapp.service.Impl;

import mk.ukim.finki.eshopapp.model.Country;
import mk.ukim.finki.eshopapp.model.dto.CountryDto;
import mk.ukim.finki.eshopapp.model.exptions.CountryNotFound;
import mk.ukim.finki.eshopapp.repository.CountryRepository;
import mk.ukim.finki.eshopapp.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Long id, String name, String continent) {
        Country country=new Country(id,name,continent);
        return this.countryRepository.save(country);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(CountryDto countrydto) {
        Country country = new Country(countrydto.getName(), countrydto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country country = new Country(name,continent);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, String name, String continent) {
        Country country = this.countryRepository.findById(id).orElseThrow(()->new CountryNotFound(id));
        country.setContinent(continent);
        country.setName(name);
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public Optional<Country> edit(Long id, CountryDto countryDto) {
        Country country = this.countryRepository.findById(id).orElseThrow(()->new CountryNotFound(id));
        country.setName(countryDto.getName());
        country.setContinent(countryDto.getContinent());
        this.countryRepository.save(country);
        return Optional.of(country);
    }

    @Override
    public void deleteById(Long id) {
        this.countryRepository.deleteById(id);
    }
}