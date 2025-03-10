package mk.ukim.finki.eshopapp.service;

import mk.ukim.finki.eshopapp.model.Author;
import mk.ukim.finki.eshopapp.model.Book;
import mk.ukim.finki.eshopapp.model.dto.BookDto;
import mk.ukim.finki.eshopapp.model.enums.BookCategory;


import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Book create(Long id, String name, BookCategory category, Author author, Integer availableCopies);
    Optional<Book> findById(Long id);
    Optional<Book> findByName(String name);
    Optional<Book> save(BookDto bookDto);
    Optional<Book> save(String name, BookCategory category, Long authorId, Integer availableCopies);
    Optional<Book> edit(Long id, String name, BookCategory category, Author author, Integer availableCopies);
    Optional<Book> edit(Long id, BookDto bookDto);
    void deleteById(Long id);
    void markBookAsTaken(Long id);

    List<Book> searchBooksByNameAndAuthor(String name, String author);

    List<Book> searchBooksByName(String name);

    List<Book> searchBooksByAuthor(String author);
}