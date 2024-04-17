package repository;

import entity.Book;
import entity.Client;

import java.sql.*;

public class DB {
    private final String user = "root";
    private final String password = "password";
    private final String url = "jdbc:mysql://localhost/librarysystem";

    public Connection connect() throws SQLException , ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, password);
    }





}
