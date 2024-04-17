package controller;

import entity.Book;
import service.BookService;

import java.util.List;

public class BookController {

    private BookService bookService= new BookService();

    public void addBook(){
        bookService.addBook();
    }

    public void deleteBook(){
        bookService.deleteBook();
    }

    public void getAllBorrowedBooks () {
         bookService.getAllBorrowedBooks();
    }
}
