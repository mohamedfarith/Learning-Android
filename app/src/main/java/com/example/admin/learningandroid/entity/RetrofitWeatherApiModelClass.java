package com.example.admin.learningandroid.entity;

import java.util.List;

public class RetrofitWeatherApiModelClass {
    String pressure;
    String humidity;
    List<Weather> weather;

    RetrofitWeatherApiModelClass(String pressure, String humidity, List<Weather> weather) {
        this.pressure = pressure;
        this.humidity = humidity;
        this.weather = weather;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String mPressure) {
        this.pressure = mPressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String mHumidity) {
        this.humidity = mHumidity;
    }

    public List<Weather> getWeatherListData() {
        return weather;
    }

    public void setWeatherListData(List<Weather> weatherListData) {
        this.weather = weatherListData;
    }
}
