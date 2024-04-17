package controller;

import service.BorrowedBookService;

public class BorrowedBookController {

    private BorrowedBookService bookService = new BorrowedBookService();

    public void addRequest(){
        bookService.addRequest();
    }

    public void getClientBorrowingHistoryById () {
        bookService.getClientBorrowingHistoryById();
    }
}
