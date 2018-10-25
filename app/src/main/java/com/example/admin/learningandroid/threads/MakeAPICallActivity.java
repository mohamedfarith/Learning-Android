package com.example.admin.learningandroid.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.admin.learningandroid.R;
import com.example.admin.learningandroid.entity.WeatherAPIModel;
import com.example.admin.learningandroid.entity.WeatherDataAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


import static com.example.admin.learningandroid.Constants.WEATHER_URL;

/* this activity class is used to implement a network call without using library
 * Here an api call to a http url is made and JSON data is retrieved
 * The JSON data is converted to JSON objects manually with the help of JSON object
 * and JSON array classes*/
public class MakeAPICallActivity extends AppCompatActivity {
    Context mContext;

    public static String getResponse() throws IOException {

        URL weatherURL = new URL(WEATHER_URL);
        HttpURLConnection weatherURLConnection = (HttpURLConnection) weatherURL.openConnection();
        weatherURLConnection.setRequestMethod("GET");
        weatherURLConnection.connect();
        InputStream weatherInputStream = new BufferedInputStream
                (weatherURLConnection.getInputStream());
        BufferedReader weatherInputBufferedReader = new BufferedReader
                (new InputStreamReader(weatherInputStream));
        StringBuilder builder = new StringBuilder();
        String weatherJSONData;
        while ((weatherJSONData = weatherInputBufferedReader.readLine()) != null) {
            builder.append(weatherJSONData);
        }
        return builder.toString();
    }

    public static ArrayList<WeatherAPIModel> getJSONObjects(String jsonResponse) {
        JSONObject getData = null;
        String pressure;
        String humidity;
        String main;
        String description;
        ArrayList<WeatherAPIModel> weatherDataList = new ArrayList<>();
        try {
            getData = new JSONObject(jsonResponse);
            JSONArray listArray = getData.getJSONArray("list");
            //opening list array
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_api_call_layout);
        APICallAsyncTask apiCallAsyncTask = new APICallAsyncTask();
        apiCallAsyncTask.execute();
    }

    class APICallAsyncTask extends AsyncTask<Object, Void, ArrayList<WeatherAPIModel>> {
        private static final String TAG = "APICallAsyncTask";

        @Override
        protected ArrayList<WeatherAPIModel> doInBackground(Object[] objects) {
            Log.d(TAG, "doInBackground: is executed");
            ArrayList<WeatherAPIModel> weatherDataList = null;
            try {
                String jsonResponse = getResponse();
                weatherDataList = getJSONObjects(jsonResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return weatherDataList;
        }

        @Override
        protected void onPostExecute(ArrayList<WeatherAPIModel> weatherDataList) {
            super.onPostExecute(weatherDataList);
            Log.d(TAG, "onPostExecute: is executed");
            RecyclerView weatherDataRecyclerView = findViewById(R.id.weather_api_data_recycler_view);
            weatherDataRecyclerView.setLayoutManager
                    (new LinearLayoutManager(MakeAPICallActivity.this));
            weatherDataRecyclerView.setAdapter(new WeatherDataAdapter(weatherDataList));
            DividerItemDecoration listItemDecoration = new DividerItemDecoration(MakeAPICallActivity.this, LinearLayoutManager.VERTICAL);
            weatherDataRecyclerView.addItemDecoration(listItemDecoration);

        }
    }
}


