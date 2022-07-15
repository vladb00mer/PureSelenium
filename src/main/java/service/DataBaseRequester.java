package service;

import io.qameta.allure.Step;
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

    @Step("Выполнение запроса Update к БД")
    public void updateStatement(String query) {

        try {
            connection.createStatement().executeUpdate(query);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("!Update not executed!");
        }
    }

    @Step("Получение значения по названию поля {label} из ответа SQL")
    public String getResultSetValueByLabel(ResultSet resultSet, String label) {

        String value = "!Default!";

        try {
            if (resultSet.getRow() == 0) {
                resultSet.next();
            }
            value = resultSet.getString(label);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
