package lt.monikos.bookeeplibrary.repository;

import lt.monikos.bookeeplibrary.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByTitle(@RequestParam("title") String title, Pageable pageable);

    Page<Book> findByAuthor(@RequestParam("author") String value, Pageable pageable);

    Page<Book> findByCategory(@RequestParam("category") String category, Pageable pageable);


}
