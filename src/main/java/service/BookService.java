package service;

import entity.Book;
import entity.Client;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {

    Scanner scanner = new Scanner(System.in);
    private BookRepository bookRepository= new BookRepository();

    public Book findBookById(long id){
        return bookRepository.findBookById(id);
    }
    public void addBook(){

        String name , author_name ;
        System.out.print("Enter Book name : ");
        name=scanner.next();

        System.out.print("Enter author name of Book : ");
        author_name=scanner.next();

        Book book= new Book(name , author_name , false );
        bookRepository.insertBook(book);
        System.out.println("Book inserted with name : "+ book.getName()  );
    }

    public void deleteBook(){
        Long id;
        System.out.print("Enter Book id to delete : ");
        id=scanner.nextLong();

        if(isIDExist(id)) {

            bookRepository.deleteBook(id);
            System.out.println("Book with id : " + id + " Deleted Successfully");
        }else{
            System.out.println("Sorry !! this book id does not exist");
        }

    }

    boolean isIDExist(Long id) {
        List<Long> IDs = bookRepository.AllIDs();

        for(Long i : IDs){
            if(i==id){
                return true;
            }
        }
        return false;
    }

    public void updateBorrowById(Long id ,Boolean borrow ){
      /*  Long id ;
        System.out.print("Enter Book id : ");
        id=scanner.nextLong();
        System.out.println();

        Boolean borrow;
        System.out.print("Enter new value of borrow (true / false) : ");
        borrow=scanner.nextBoolean();
        System.out.println();*/

        bookRepository.updateBorrowById(id , borrow);
        System.out.println("Book Updated successfully");

    }

    public void getAllBorrowedBooks () {
        List<Book> books = bookRepository.getAllBorrowedBooks();
        for(Book i : books){
             i.display();
        }
    }


}
