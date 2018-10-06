package com.example.admin.learningandroid.threads;

import com.example.admin.learningandroid.Constants;
import com.example.admin.learningandroid.entity.ListDataRetrieveModelClass;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.admin.learningandroid.Constants.BASE_WEATHER_URL;

public interface ApiCall {
    String weatherURL = "https://andfun-weather.udacity.com/";
@GET("staticweather")
    Call<ListDataRetrieveModelClass> getWeatherData();
}
