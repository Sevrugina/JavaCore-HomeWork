package org.example.repository;

import org.example.entity.WeatherData;
import org.example.dto.WeatherResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

// Репозиторий для работы
public interface DatabaseRepository {
    boolean saveWeatherData(WeatherData weatherData) throws SQLException;
    List<WeatherData> getAllSavedData() throws SQLException;
    void closeConnection();
}
