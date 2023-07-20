package lt.monikos.bookeeplibrary.responsemodels;

import lombok.Data;
import lt.monikos.bookeeplibrary.entity.Book;

@Data
public class ShelfCurrentLoansResponse {

    private Book book;

    private int daysLeft;

    public ShelfCurrentLoansResponse(Book book, int daysLeft) {
        this.book = book;
        this.daysLeft = daysLeft;
    }
}
