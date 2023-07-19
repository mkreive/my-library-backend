package lt.monikos.bookeeplibrary.service;

import lt.monikos.bookeeplibrary.entity.Book;
import lt.monikos.bookeeplibrary.entity.Checkout;
import lt.monikos.bookeeplibrary.repository.BookRepository;
import lt.monikos.bookeeplibrary.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CheckoutRepository checkoutRepository;

//    public BookService(BookRepository bookRepository, CheckoutRepository checkoutRepository) {
//        this.bookRepository = bookRepository;
//        this.checkoutRepository = checkoutRepository;
//    }

    public Book checkoutBook(String userEmail, Long bookId) throws Exception {
        Optional<Book> book = bookRepository.findById(bookId);

        Checkout validateCheckout = checkoutRepository.findByUserEmailAndBookId(userEmail, bookId);

        if(!book.isPresent() || validateCheckout != null || book.get().getCopiesAvailable() <= 0){
            throw new Exception("Book doesn't exist or already checked out by user");
        }

        book.get().setCopiesAvailable(book.get().getCopiesAvailable() - 1);
        bookRepository.save(book.get());

        Checkout checkout = new Checkout(
                userEmail, LocalDate.now().toString(), LocalDate.now().plusDays(7).toString(),
                book.get().getId()
        );

        checkoutRepository.save(checkout);

        return book.get();
    }







}
