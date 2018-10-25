package com.example.admin.learningandroid.services;

import android.app.IntentService;

import android.content.Intent;
import android.support.annotation.Nullable;

import com.example.admin.learningandroid.entity.WeatherAPIModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.example.admin.learningandroid.Constants.NOTIFICATION;
import static com.example.admin.learningandroid.Constants.WEATHER_LIST;
import static com.example.admin.learningandroid.Constants.WEATHER_URL;


public class WeatherIntentService extends IntentService {

    public WeatherIntentService() {
        super("WeatherIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            URL url = new URL(WEATHER_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(bufferedInputStream));
            String weatherJSONData;
            StringBuilder stringBuilder = new StringBuilder();
            while ((weatherJSONData = bufferedReader.readLine()) != null) {
                stringBuilder.append(weatherJSONData);
            }
            String weatherData = stringBuilder.toString();
            ArrayList<WeatherAPIModel> weatherListData = getJSONData(weatherData);
            sendBroadcastToActivity(weatherListData);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendBroadcastToActivity(ArrayList<WeatherAPIModel> weatherListData) {
        Intent intent = new Intent(NOTIFICATION);
        intent.putParcelableArrayListExtra(WEATHER_LIST, weatherListData);
        sendBroadcast(intent);
    }

    ArrayList<WeatherAPIModel> getJSONData(String weatherDataResponse) {
        ArrayList<WeatherAPIModel> weatherDataList = new ArrayList<>();
        JSONObject getData;
        String pressure;
        String humidity;
        String main;
        String description;
        try {
            getData = new JSONObject(weatherDataResponse);
            JSONArray listArray = getData.getJSONArray("list");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject listObject = listArray.getJSONObject(i);
                pressure = listObject.getString("pressure");
                humidity = listObject.getString("humidity");
                JSONArray weatherArray = listObject.getJSONArray("weather");
                JSONObject weatherList = weatherArray.getJSONObject(0);
                main = weatherList.getString("main");
                description = weatherList.getString("description");
                weatherDataList.add(new WeatherAPIModel(pressure, humidity, main, description));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weatherDataList;
    }
}
