package lt.monikos.bookeeplibrary.controller;

import lt.monikos.bookeeplibrary.entity.Book;
import lt.monikos.bookeeplibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestParam Long bookId) throws Exception {
        String userEmail = "user@email.com";
        return bookService.checkoutBook(userEmail, bookId);
    }
}
