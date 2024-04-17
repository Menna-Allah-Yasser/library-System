package entity;


import java.time.LocalDate;
import java.util.Date;

public class BorrowedBook {

    private Long id;

    private Long book_id;

    private Long client_id;

    private int borrowing_time_in_days;

    public BorrowedBook() {
    }

    public BorrowedBook(Long book_id, Long client_id, int borrowing_time_in_days) {
        this.book_id = book_id;
        this.client_id = client_id;
        this.borrowing_time_in_days = borrowing_time_in_days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public int getBorrowing_time_in_days() {
        return borrowing_time_in_days;
    }

    public void setBorrowing_time_in_days(int borrowing_time_in_days) {
        this.borrowing_time_in_days = borrowing_time_in_days;
    }

    public void display() {
        System.out.println( "BorrowedBook{" +
                " book_id=" + book_id +
                ", client_id=" + client_id +
                ", borrowing_time_in_days=" + borrowing_time_in_days +
                '}');
    }
}
