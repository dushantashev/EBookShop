package mk.ukim.finki.eshopapp.repository;

import mk.ukim.finki.eshopapp.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
