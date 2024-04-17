package service;

import entity.Book;
import entity.BorrowedBook;
import repository.BorrowedBookRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BorrowedBookService {

    Scanner scanner = new Scanner(System.in);

    private BorrowedBookRepository bookRepository = new BorrowedBookRepository();

    private ClientService clientService= new ClientService();

    private BookService bookService = new BookService();

    public void addRequest (){
        Long client_id , book_id ;
        int returnTime;

        System.out.print("Enter client id : ");
        client_id = scanner.nextLong();
        boolean tst1 = clientService.isIDExist(client_id);

        System.out.print("Enter Book id : ");
        book_id=scanner.nextLong();
        boolean tst2 = bookService.isIDExist(book_id);

        System.out.print("Enter return Time : ");
        returnTime=scanner.nextInt();

        Book book = bookService.findBookById(book_id);

        if(tst1 == true && tst2 == true && book.isBorrowed()== false ) {
            BorrowedBook borrowedBook = new BorrowedBook(book_id, client_id, returnTime);
            bookRepository.insertRequest(borrowedBook);
            bookService.updateBorrowById(book_id , true);
            System.out.println("Have a nice journey with your book, ya sade2 ^_^ ");
        }else{
            if(book.isBorrowed()== true)
                System.out.println("Sorry ! Book is Borrowed");
            if(tst1==false)
                System.out.println("client_id does not exist");
            if(tst2==false)
                System.out.println("book_id does not exist");
        }
    }

    public void getClientBorrowingHistoryById () {

        Long id;
        System.out.print("Enter Client id : ");
        id= scanner.nextLong();

        boolean tst1=clientService.isIDExist(id);
        if(tst1==true){
            List<BorrowedBook> books = bookRepository.getClientBorrowingHistoryById(id);
            for(BorrowedBook i : books){
                i.display();
            }
        }else{
            System.out.println("Sorry !! client ID is not Exist");
        }

    }

}
