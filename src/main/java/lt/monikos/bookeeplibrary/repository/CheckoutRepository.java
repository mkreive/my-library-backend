package lt.monikos.bookeeplibrary.repository;

import lt.monikos.bookeeplibrary.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

    Checkout findByUserEmailAndBookId(String userEmail, Long bookId);

    List<Checkout> findBooksByUserEmail(String userEmail);

    // TODO - query selektoru susitvarkyti!
//    @Modifying
//    @Query("delete from Checkout where book_id in :book_id")
//    void deleteAllByBookId(@Param("book_id") Long bookId);
}
