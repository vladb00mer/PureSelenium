package service;

import io.qameta.allure.Step;
import java.sql.*;

public class SanchezDataBaseRequester {

    private static String dbUrl;
    private static String dbUser;
    private static String dbPassword;

    public SanchezDataBaseRequester(String dbUrl, String dbUser, String dbPassword) {

        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    private static Connection driverManager() throws SQLException, ClassNotFoundException {

        Class.forName("sanchez.jdbc.driver.ScDriver");

        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @Step("Выполнение запроса Select к БД Profile для получения {returnColumnValue}")
    public static String selectValueFromDataBase(String select, String returnColumnValue) {

        String result = "!Default!";

        try (Connection connection = driverManager();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(select)) {

            while (resultSet.next()) {
                return resultSet.getString(returnColumnValue);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Step("Выполнение запроса Update к БД Profile")
    public void update(String update) {

        Connection connection = null;
        try {
            connection = driverManager();
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
