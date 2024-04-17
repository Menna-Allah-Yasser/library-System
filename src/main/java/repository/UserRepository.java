package repository;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private DB db = new DB();
    Connection connection;
    String query;
    PreparedStatement preparedStatement;
    ResultSet resultSet = null;
    public void insertUser(User user){

        try {

            connection = db.connect();
            query = "insert into user ( pass , firstname , lastName  ) values (?, ? , ?  )";
            preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(1, user.getPass());
            preparedStatement.setString(2, user.getFname());
            preparedStatement.setString(3, user.getLname());

            preparedStatement.execute();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

   public  String getPassById (Long id ){
        String pass="";
        try {
            connection = db.connect();
            query = "select pass from user where id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                pass = resultSet.getString("pass");
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pass;
    }
}
