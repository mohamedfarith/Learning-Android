package com.example.admin.learningandroid.threads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.learningandroid.R;
import com.example.admin.learningandroid.entity.WeatherAPIModelClass;
import com.example.admin.learningandroid.layouts.RecyclerViewAdapter;

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
import java.util.zip.Inflater;


import static com.example.admin.learningandroid.Constants.WEATHER_URL;

/* this activity class is used to implement a network call without using library
 * Here an api call to a http url is made and JSON data is retrieved
 * The JSON data is converted to JSON objects manually with the help of JSON object
 * and JSON array classes*/
public class MakeAPICallActivity extends AppCompatActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_api_call_layout);
        APICallAsyncTask apiCallAsyncTask = new APICallAsyncTask();
        apiCallAsyncTask.execute();
    }


    public String getResponse() throws IOException {

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


    ArrayList<WeatherAPIModelClass> getJSONObjects(String jsonResponse) {
        JSONObject getData = null;
        String pressure;
        String humidity;
        String main;
        String description;
         ArrayList<WeatherAPIModelClass> weatherDataList = new ArrayList<>();
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
                weatherDataList.add(new WeatherAPIModelClass(pressure, humidity, main, description));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weatherDataList;
    }

    class APICallAsyncTask extends AsyncTask<Object, Void, ArrayList<WeatherAPIModelClass>> {
        private static final String TAG = "APICallAsyncTask";

        @Override
        protected ArrayList<WeatherAPIModelClass> doInBackground(Object[] objects) {
            Log.d(TAG, "doInBackground: is executed");
            ArrayList<WeatherAPIModelClass> weatherDataList = null;
            try {
                String jsonResponse = getResponse();
                weatherDataList = getJSONObjects(jsonResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return weatherDataList;
        }

        @Override
        protected void onPostExecute(ArrayList<WeatherAPIModelClass> weatherDataList) {
            super.onPostExecute(weatherDataList);
            Log.d(TAG, "onPostExecute: is executed");
            RecyclerView weatherDataRecyclerView = findViewById(R.id.weather_api_data_recycler_view);
            weatherDataRecyclerView.setLayoutManager
                    (new LinearLayoutManager(MakeAPICallActivity.this));
            weatherDataRecyclerView.setAdapter(new WeatherDataRecyclerViewAdapter(weatherDataList));
            DividerItemDecoration listItemDecoration = new DividerItemDecoration(MakeAPICallActivity.this,LinearLayoutManager.VERTICAL);
            weatherDataRecyclerView.addItemDecoration(listItemDecoration);

        }
    }
}
//Array adapter designed to display the contents of the weather data retrieved from the url

class WeatherDataRecyclerViewAdapter extends
        RecyclerView.Adapter<WeatherDataRecyclerViewAdapter.WeatherDataViewHolder> {
    ArrayList<WeatherAPIModelClass> weatherList;
    Context mContext;

    WeatherDataRecyclerViewAdapter(ArrayList<WeatherAPIModelClass> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public WeatherDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View weatherDataView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_list, parent, false);
        return new WeatherDataViewHolder(weatherDataView);
    }

    @Override
    public void onBindViewHolder(WeatherDataViewHolder holder, int position) {
        String message = null;
        WeatherAPIModelClass weatherDataDisplay = weatherList.get(position);
        //message = "pressure "+weatherDataDisplay.getPressure();
        holder.mPressure.setText(weatherDataDisplay.getPressure());
       // message = "humidity "+weatherDataDisplay.getHumidity();
        holder.mHumidity.setText(weatherDataDisplay.getHumidity());
       // message = "Main "+weatherDataDisplay.getMain();
        holder.mMain.setText(weatherDataDisplay.getMain());
       // message = "Description "+weatherDataDisplay.getDescription();
        holder.mDescription.setText(weatherDataDisplay.getDescription());


    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    class WeatherDataViewHolder extends RecyclerView.ViewHolder {
        TextView mPressure;
        TextView mHumidity;
        TextView mMain;
        TextView mDescription;

        WeatherDataViewHolder(View itemView) {
            super(itemView);
            mPressure = itemView.findViewById(R.id.txt_pressure);
            mHumidity = itemView.findViewById(R.id.txt_humidity);
            mMain = itemView.findViewById(R.id.txt_main);
            mDescription = itemView.findViewById(R.id.txt_description);

        }
    }
}