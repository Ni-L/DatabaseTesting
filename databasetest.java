package com.briedgelab.selenium.Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.*;

public class databasetest {
    static Connection connection = null;
    private static Statement statement;
    private static String url = "jdbc:mysql://localhost:3306/emp";

    @BeforeTest
    public Connection authentication() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp");
        statement = connection.createStatement();
        return connection;
    }

    @Test(priority = 1)
    public void should_InsertQuery() throws Exception {

            connection = this.authentication();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into empdata values" +
                    "(?,?,?)");
            preparedStatement.setInt(1,8);
            preparedStatement.setString(2,"ni");
            preparedStatement.setString(4,"Na");

            preparedStatement.executeUpdate();

        }
    public void shouldReturn_AllDataFromDatabase() throws SQLException {


        String query = "select * from empdata";
        ResultSet res = statement.executeQuery(query);

        while (res.next()) {
            System.out.print(res.getString(1));
            System.out.print(" " + res.getString(2));
            System.out.print(" " + res.getString(3));

        }

    }
    @AfterTest
    public void endTest() throws Exception {
        if (connection != null)
            connection.close();
    }
    }

