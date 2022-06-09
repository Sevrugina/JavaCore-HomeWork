package org.example;

import org.example.enums.Periods;
import java.io.IOException;

public interface WeatherProvider {
    public void getWeather(Periods period) throws IOException;
}
