package mk.ukim.finki.eshopapp.repository;

import mk.ukim.finki.eshopapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findByName(String name);
}
