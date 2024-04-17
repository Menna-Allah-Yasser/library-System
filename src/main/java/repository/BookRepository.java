package repository;

import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private DB db = new DB();
    Connection connection;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet = null;

    public void insertBook(Book book){

        try {

            connection = db.connect();
            query = "insert into book ( name , author_name ,  is_borrowed ) values (?, ? , ? )";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor_name());
            preparedStatement.setBoolean(3, book.isBorrowed());
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void deleteBook(Long id){
        try {
            connection = db.connect();
            query = "delete from book where id = ? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
             preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Book findBookById(Long id){
        Book book = new Book();
        try {
            connection = db.connect();
            query = "select * from book where id = ? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                book.setId(resultSet.getLong("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor_name(resultSet.getString("author_Name"));
                book.setBorrowed(resultSet.getBoolean("is_borrowed"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    public List<Long> AllIDs(){
        List<Long> IDs = new ArrayList<>();
        try {

            connection = db.connect();
            query = "select id from book";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                IDs.add(id);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return IDs;
    }

    public void updateBorrowById(Long id , Boolean borrow){
        try {
            connection = db.connect();
            query = "update book set is_borrowed = ? where id = ? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, borrow);
            preparedStatement.setLong(2, id);
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Book> getAllBorrowedBooks (){
        List<Book> books= new ArrayList<>();
        try {
            connection = db.connect();
            query = "select * from book where is_borrowed = 1 ";
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String author_name = resultSet.getString("author_Name");

                Book book = new Book(name , author_name , true);
                books.add(book);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return books;
    }

}
