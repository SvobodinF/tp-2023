package Repository.Samples.Database;

import java.io.IOException;
import java.sql.*;

import Models.Datable;
import Models.Route;
import com.mysql.cj.jdbc.Driver;

import javax.xml.crypto.Data;

public class ConnectionManager {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "qwerty123";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    public static Statement statement;
    public static Connection connection;

    static {
        try{
            connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static {
        try{
            statement = connection.createStatement();

            initialContext();
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static void initialContext() {
        try {
            createTable("Routes", "ID int AUTO_INCREMENT," +
                    "Name varchar");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends Datable> void createTable(String name, String properties) throws SQLException {

        statement.execute("USE RouteApplication");
        statement.execute("CREATE TABLE " + name
                + " (" + properties + ")");
    }

    /*public void getAll(String tableName) {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM carShop");

        while(resultSet.next()){
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString(2) +
                    resultSet.getString(3));
        }
    }*/


    /*
    *
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");

        statement.execute("INSERT INTO test (name, name1, name2) value ('test, tset,sets')");

        ResultSet resultSet = statement.executeQuery("SELECT * FROM carShop");

        while(resultSet.next()){
            System.out.println(resultSet.getString(1) + " " +
                    resultSet.getString(2) +
                    resultSet.getString(3));
        }*/
}
