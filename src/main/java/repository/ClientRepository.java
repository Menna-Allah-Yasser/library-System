package repository;

import entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private DB db = new DB();
    Connection connection;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet = null;

    public void insertClient(Client client){

        try {

            connection = db.connect();
            query = "insert into client ( Email , firstname , lastName , address ) values (?, ? , ? , ? )";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, client.getEmail());
            preparedStatement.setString(2, client.getFname());
            preparedStatement.setString(3, client.getLname());
            preparedStatement.setString(4, client.getAddress());
            preparedStatement.execute();
            System.out.println("Client inserted with Email : "+ client.getEmail());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

   public List<Long> AllIDs(){
        List<Long> IDs = new ArrayList<>();
        try {

            connection = db.connect();
            query = "select id from client";
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
}
