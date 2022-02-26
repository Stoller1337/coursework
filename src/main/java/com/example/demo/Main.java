package com.example.demo;


import jdbc.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try(Connection connection = JDBCUtils.getNewConnection()){
            JDBCUtils.changePrice(connection, 1, "hummer", 200);
            JDBCUtils.printWarehouseList(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
