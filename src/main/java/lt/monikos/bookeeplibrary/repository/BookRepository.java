package lt.monikos.bookeeplibrary.repository;

import lt.monikos.bookeeplibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findById(int id);
}
