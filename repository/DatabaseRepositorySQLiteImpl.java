package org.example.repository;

import org.example.entity.WeatherData;
import org.example.provider.ApplicationGlobalState;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    String filename = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public DatabaseRepositorySQLiteImpl() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        filename = ApplicationGlobalState.getInstance().getDbFileName();
        connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        connection.createStatement().execute(
                "CREATE TABLE IF NOT EXISTS weather (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "city TEXT NOT NULL," +
                        "local_date TEXT NOT NULL," +
                        "day_text TEXT NOT NULL," +
                        "night_text TEXT NOT NULL," +
                        "min_temperature REAL NOT NULL," +
                        "max_temperature REAL NOT NULL);");
        preparedStatement = connection.prepareStatement(
                "INSERT INTO weather " +
                        "(city, local_date, day_text, night_text, min_temperature, max_temperature) " +
                        "VALUES (?,?,?,?,?,?)");
    }


    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        try  {
            preparedStatement.setString(1, weatherData.getCity());
            preparedStatement.setString(2, weatherData.getLocalDate());
            preparedStatement.setString(3, weatherData.getDaytext());
            preparedStatement.setString(4, weatherData.getNightText());
            preparedStatement.setDouble(5, weatherData.getMinTemperature());
            preparedStatement.setDouble(6, weatherData.getMaxTemperature());
            return preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM weather");
        List<WeatherData> weatherDataList = new ArrayList<>();
        while (resultSet.next()) {
            weatherDataList.add(new WeatherData(
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getDouble(6),
                    resultSet.getDouble(7)));
        }
        return weatherDataList;
    }

    public void closeConnection() {
        try {
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
