package com.example.admin.learningandroid.threads;

import com.example.admin.learningandroid.entity.WeatherAPIModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {
    String weatherURL = "https://andfun-weather.udacity.com/";

    @GET("staticweather")
    Call<WeatherAPIModel> getWeatherData();
}
