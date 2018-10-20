package com.example.admin.learningandroid.entity;

import java.util.List;

public class WeatherAPIModel {
    List<WeatherAPIModel> list;
    String pressure;
    String humidity;
    List<WeatherAPIModel> weather;
    String main;
    String description;

    public WeatherAPIModel(String pressure, String humidity, String main, String description) {
        this.pressure = pressure;
        this.humidity = humidity;
        this.main = main;
        this.description = description;
    }

    public List<WeatherAPIModel> getList() {
        return list;
    }

    public List<WeatherAPIModel> getWeather() {
        return weather;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

}
