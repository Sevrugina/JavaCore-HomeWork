package org.example.entity;


public class WeatherData {

    private String city;
    private String localDate;
    private String dayText;
    private String nightText;
    private Double minTemperature;
    private Double maxTemperature;

    public WeatherData() {
    }

    public WeatherData( String city, String localDate, String dayText, String nightText,Double minTemperature,Double maxTemperature) {
        this.city = city;
        this.localDate = localDate;
        this.dayText = dayText;
        this.nightText = nightText;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public String getDaytext() {
        return dayText;
    }

    public void setDaytext(String daytext) {
        this.dayText = daytext;
    }

    public String getNightText() {
        return nightText;
    }

    public void setNightText(String nightText) {
        this.nightText = nightText;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }
}
