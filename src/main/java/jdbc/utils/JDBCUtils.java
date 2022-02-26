package jdbc.utils;


import java.sql.*;

public class JDBCUtils {
    public static Connection getNewConnection() throws SQLException {
        final String URL = "jdbc:postgresql://localhost:5432/test_db";
        final String USER = "postgres";
        final String PASS = "4512";
        Connection connection = DriverManager.getConnection(URL,USER,PASS);

        if (connection.isValid(1)){
            System.out.println("successful");
        }
        return connection;
    }
    public static void printWarehouseList(Connection connection) throws SQLException{
        String sql = "SELECT * FROM warehouse";
        try(PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()
        ){
            while(resultSet.next()){
                String SalesName = resultSet.getString("name");
                int amount = resultSet.getInt(4);
                System.out.println(SalesName + ": " + amount);
            }
        }
    }

    public static void changePrice(Connection connection, int id, String name, int newAmount) throws SQLException {
        String sql = "UPDATE warehouse "+
                "SET amount = ?"+
                "WHERE id = ?"+
                "AND name = ?";

        try(PreparedStatement statement  = connection.prepareStatement(sql)) {
            statement.setInt(1, newAmount);
            statement.setInt(2, id);
            statement.setString(3, name);
            statement.executeUpdate();
        }

    }
}
