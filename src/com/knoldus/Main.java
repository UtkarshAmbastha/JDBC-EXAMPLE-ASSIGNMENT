package com.knoldus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {

        String URL = "jdbc:mysql://localhost:3306/Shopping";
        String User_Name = "root";
        String Password = "utkarsh@15";

        int data;

        String query = "Select SUM(cart.qty*product.price) as TOTAL-PRICE FROM cart, product WHERE product.pid = Cart.PID";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(URL, User_Name, Password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        resultSet.next();

        data = resultSet.getInt(1);
        System.out.println(data);

        statement.close();
        connection.close();

    }
}

