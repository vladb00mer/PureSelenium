package service;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;

public class DataBaseRequester {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public DataBaseRequester(String url, String user, String password) {

        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("!Driver not registered!");
        }

        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@"+url, user, password);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("!Connection not created!");
        }
    }

    public ResultSet executeStatement(String query) {

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("!Result set not executed!");
        }

        return resultSet;
    }

    public String getResultSetValue(ResultSet resultSet, String label) throws SQLException {

        String value = null;

        while (resultSet.next()) {

            value = resultSet.getNString(label);
        }
        return value;
    }

    public void closeConnection() {

        try {
            connection.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("!Error closing connection!");
        }
    }
}