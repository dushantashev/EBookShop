package mk.ukim.finki.eshopapp.service;



import mk.ukim.finki.eshopapp.model.Author;
import mk.ukim.finki.eshopapp.model.Country;
import mk.ukim.finki.eshopapp.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Author create(Long id, String name, String surname, Country country);
    List<Author> findAll();
    Optional<Author> findById(Long id);
    Optional<Author> edit(Long id,String name, String surname, Country country);
    Optional<Author> edit(Long id, AuthorDto authorDto);
    void deleteById(Long id);
    Optional<Author> save(String name, String surname, Country country);
    Optional<Author> save(AuthorDto authorDto);

}