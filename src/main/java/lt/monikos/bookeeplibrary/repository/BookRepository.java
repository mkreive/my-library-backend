package lt.monikos.bookeeplibrary.repository;

import lt.monikos.bookeeplibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
