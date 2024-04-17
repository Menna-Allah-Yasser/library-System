package repository;

import entity.Book;
import entity.BorrowedBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowedBookRepository {
    private DB db = new DB();
    Connection connection;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet = null;

    public void insertRequest(BorrowedBook book){

        try {

            connection = db.connect();
            query = "insert into borrowed ( client_id , book_id , return_time ) values (?, ? , ?  )";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, book.getClient_id());
            preparedStatement.setLong(2, book.getBook_id());
            preparedStatement.setInt(3, book.getBorrowing_time_in_days());
            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public List<BorrowedBook> getClientBorrowingHistoryById (Long id){
        List<BorrowedBook> books= new ArrayList<>();
        try {
            connection = db.connect();
            query = "select * from Borrowed where client_id = ? ";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long book_id = resultSet.getLong("book_id");
                int return_time = resultSet.getInt("return_time");

                BorrowedBook book = new BorrowedBook(book_id , id , return_time);
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
