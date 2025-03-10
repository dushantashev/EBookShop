package mk.ukim.finki.eshopapp.repository;

import mk.ukim.finki.eshopapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String name);

    List<Book> findByNameContainingIgnoreCase(String name);


    List<Book> findByAuthorNameContainingIgnoreCase(String authorName);


    List<Book> findByNameContainingIgnoreCaseAndAuthorNameContainingIgnoreCase(String name, String authorName);
}