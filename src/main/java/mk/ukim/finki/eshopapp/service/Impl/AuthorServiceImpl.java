package mk.ukim.finki.eshopapp.service.Impl;


import jakarta.transaction.Transactional;
import mk.ukim.finki.eshopapp.model.Author;
import mk.ukim.finki.eshopapp.model.Country;
import mk.ukim.finki.eshopapp.model.dto.AuthorDto;
import mk.ukim.finki.eshopapp.model.exptions.AuthorNotFound;
import mk.ukim.finki.eshopapp.repository.AuthorRepository;
import mk.ukim.finki.eshopapp.repository.CountryRepository;
import mk.ukim.finki.eshopapp.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Author create(Long id, String name, String surname, Country country) {
        Author author= new Author(id,name,surname,country);
        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Author> save(String name, String surname,Country country) {



        Author author = new Author(name, surname, country);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Author author = new Author(authorDto.getName(), authorDto.getSurname(),authorDto.getCountry());
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname,Country country) {
        Author author = this.authorRepository.findById(id).orElseThrow(()-> new AuthorNotFound(id));
        author.setCountry(country);
        author.setName(name);
        author.setSurname(surname);
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public Optional<Author> edit(Long id, AuthorDto authorDto) {
        Author author = this.authorRepository.findById(id).orElseThrow(()-> new AuthorNotFound(id));
        author.setCountry(authorDto.getCountry());
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        this.authorRepository.save(author);
        return Optional.of(author);
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.deleteById(id);
    }


}