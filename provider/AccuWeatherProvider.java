package org.example.provider;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import com.fasterxml.jackson.core.type.TypeReference;
import org.example.repository.DatabaseRepository;
import org.example.repository.DatabaseRepositorySQLiteImpl;
import org.example.dto.WeatherResponse;
import org.example.entity.WeatherData;
import org.example.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuWeatherProvider  implements WeatherProvider  {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST_ENDPOINT = "forecasts";

    private static final String FORECAST_PERIOD = "5day";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST = "forecasts";

    private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
    private static final String API_VERSION = "v1";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final DatabaseRepository repository = new DatabaseRepositorySQLiteImpl();

    public AccuWeatherProvider() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void getWeather(Periods periods) throws IOException, SQLException {

        if (periods.equals(Periods.NOW)) {
            String cityKey = detectCityKey();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String responseList = client.newCall(request).execute().body().string();
            List<WeatherResponse> weatherResponsesList =
                    objectMapper.readValue(responseList, new TypeReference<List<WeatherResponse>>() {});
            WeatherResponse weather = weatherResponsesList.get(0);
            System.out.println("City:" + ApplicationGlobalState.getInstance().getSelectedCity());
            System.out.println("Temperature:" + weather.getTemperature().getMetric().getValue());
            System.out.println("Description:" + weather.getWeatherText());
        }

        if (periods.equals(Periods.FIVE_DAYS)) {
            String cityKey = detectCityKey();
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("http")
                    .host(BASE_HOST)
                    .addPathSegment(FORECAST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST_TYPE)
                    .addPathSegment(FORECAST_PERIOD)
                    .addPathSegment(cityKey)
                    .addQueryParameter("apikey", API_KEY)
                    .addQueryParameter("language", "ru-ru")
                    .addQueryParameter("metric", "true")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .url(url)
                    .build();

            String responseList = client.newCall(request).execute().body().string();

            int firstIndexBody = responseList.indexOf("[{\"Date\"");
            int lastIndexBody = responseList.lastIndexOf("}");
            responseList = responseList.substring(firstIndexBody, lastIndexBody);

            List<WeatherResponse> weatherResponsesList =
                    objectMapper.readValue(responseList, new TypeReference<List<WeatherResponse>>() {});
            System.out.println("City: " + ApplicationGlobalState.getInstance().getSelectedCity());
            System.out.println("______5 days________");
            for (WeatherResponse weather: weatherResponsesList){
                System.out.println("NextDate: " + weather.getDate());
                System.out.println("Night: " + weather.getNight().getWeatherText());
                System.out.println("Min(C): " + weather.getTemperature().getMinimum().getValue());
                System.out.println("Day: " + weather.getDay().getWeatherText());
                System.out.println("Max(C): " + weather.getTemperature().getMaximum().getValue());
                System.out.println();
                WeatherData weatherData = new WeatherData(
                        ApplicationGlobalState.getInstance().getSelectedCity(),
                        weather.getDate().substring(0,10),
                        weather.getNight().getWeatherText(),
                        weather.getDay().getWeatherText(),
                        castFloatToDouble(weather.getTemperature().getMinimum().getValue()),
                        castFloatToDouble(weather.getTemperature().getMaximum().getValue()));
                repository.saveWeatherData(weatherData);
            }

        }

        if (periods.equals(Periods.BASE)) {
            getAllFromDb();
        }
    }

    private Double castFloatToDouble (float value) {
        return (double) value;
    }

    public List<WeatherData> getAllFromDb() throws SQLException {
        List<WeatherData> weatherDataList = repository.getAllSavedData();
        System.out.println("______SQLite________");
        for (WeatherData weatherData : weatherDataList) {
            System.out.println("NextDate: " + weatherData.getLocalDate());
            System.out.println("Night: " + weatherData.getNightText());
            System.out.println("Min(C): " + weatherData.getMinTemperature());
            System.out.println("Day: " + weatherData.getDaytext());
            System.out.println("Max(C): " + weatherData.getMaxTemperature());
            System.out.println();
        }
        return weatherDataList;
    }

    public String detectCityKey() throws IOException {
        String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete")
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(detectLocationURL)
                .build();

        Response response = client.newCall(request).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Impossible to read information about the city." +
                    "Server response code = " + response.code() + " response body = " + response.body().string());
        }
        String jsonResponse = response.body().string();
        System.out.println("Searching " + selectedCity);

        if (objectMapper.readTree(jsonResponse).size() > 0) {
            String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
            String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
            System.out.println("Found City: " + cityName + "(" + countryName + ")");
        } else throw new IOException("Server returns 0 cities");

        return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
    }

    public String trimBrackets(JsonNode string) {
        int lastIndexBody = string.toString().lastIndexOf("\"");
        return string.toString().substring(1,lastIndexBody);
    }
}
