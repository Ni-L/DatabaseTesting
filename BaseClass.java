package com.briedgelab.selenium.batch007;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.*;

public class BaseClass {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/emp";
        Connection con = null;


        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp");
        Statement statement = con.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM empdata");
        ResultSetMetaData resultSetMetaData = resultset.getMetaData();

        System.out.println("col1" + "\t" + "col2");
        while (resultset.next()) {
            String col1 = resultset.getString(1);
            String col2 = resultset.getString(2);
            System.out.println(col1 + "\t\t" + col2);
        }

    }
}
