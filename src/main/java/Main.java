import controller.BookController;
import controller.BorrowedBookController;
import controller.ClientController;
import controller.UserController;
import entity.BorrowedBook;
import entity.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        User user= new User();
        UserController userController = new UserController();
        ClientController clientController = new ClientController();
        BookController bookController= new BookController();
        BorrowedBookController borrowedBook= new BorrowedBookController();


        System.out.println("Login as a User ");
        boolean tst=userController.authentication();

        if(tst==true) {

            System.out.println("Enter :1  Add new Client ");
            System.out.println("Enter :2  Add new Book ");
            System.out.println("Enter :3  Remove Existing Book ");
            System.out.println("Enter :4  Make Book Request ");
            System.out.println("Enter :5  Generate All Borrowed Books Report ");
            System.out.println("Enter :6  Generate client Borrowing History Report ");
            System.out.println("Enter :7  Add new user ");
            System.out.println("Enter :8  Close System ");

            while (true) {
                int x= scanner.nextInt();

                if (x == 1) {
                    System.out.println("Adding new Client... ");
                    clientController.addClient();
                } else if (x == 2) {
                    System.out.println("Adding new Book... ");
                    bookController.addBook();
                } else if (x == 3) {
                    System.out.println("Removing Existing Book... ");
                    bookController.deleteBook();
                } else if (x == 4) {
                    System.out.println("Request for a Book... ");
                    borrowedBook.addRequest();
                } else if (x == 5) {
                    System.out.println("Generating All Borrowed Books Report... ");
                    bookController.getAllBorrowedBooks();
                } else if (x == 6) {
                    System.out.println("Generating client Borrowing History Report... ");
                    borrowedBook.getClientBorrowingHistoryById();
                } else if (x == 7) {
                    System.out.println("Adding new user... ");
                    userController.addUser();
                } else if (x == 8) {
                    System.out.println("closing system ...");
                    return;
                } else {
                    System.out.println("this number can not be recognised \n " +
                            "please Enter valid number !!\n");
                }
            }

        }
    }
}