package com.example.admin.learningandroid.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.admin.learningandroid.R;
import com.example.admin.learningandroid.entity.WeatherAPIModel;
import com.example.admin.learningandroid.entity.WeatherDataAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiCallUsingRetrofit extends AppCompatActivity {
    ArrayList<WeatherAPIModel> weatherAPIModelClassArrayList = new ArrayList<>();
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_weather_api_layout);
        final RecyclerView weatherDataDisplay = findViewById(R.id.retrofit_weather_api_recycler_view);
        mProgressBar = findViewById(R.id.progress_Bar_weather_data);
        Retrofit dataRetreive = new Retrofit.Builder()
                .baseUrl(ApiCall.weatherURL)
                .addConverterFactory(GsonConverterFactory
                        .create()).build();
        ApiCall apiCall = dataRetreive.create(ApiCall.class);
        Call<WeatherAPIModel> listDataRetrieveModelClassCall = apiCall.getWeatherData();
        listDataRetrieveModelClassCall.enqueue(new Callback<WeatherAPIModel>() {
            @Override
            public void onResponse(Call<WeatherAPIModel> call, Response<WeatherAPIModel> response) {
                WeatherAPIModel responseData = response.body();
                //Getting the list Array by creating an object of ListDataRetreiveModelClass
                for (int i = 0; i < responseData.getList().size(); i++) {
                    //Getting the objects available inside list array
                    List<WeatherAPIModel> list = responseData.getList();
                    String pressure = list.get(i).getPressure();
                    String humidity = list.get(i).getHumidity();
                    //Getting the key - value pairs available inside weather list at index 0
                    List<WeatherAPIModel> weather = list.get(i).getWeather();
                    String main = weather.get(0).getMain();
                    String description = weather.get(0).getDescription();
                    if (!TextUtils.isEmpty(pressure) && (!TextUtils.isEmpty(humidity) && (!TextUtils.isEmpty(main) && (!TextUtils.isEmpty(description))))) {
                        weatherAPIModelClassArrayList.add(new WeatherAPIModel(pressure, humidity, main, description));
                    }
                    mProgressBar.setVisibility(View.GONE);
                    if (weatherAPIModelClassArrayList != null) {
                        weatherDataDisplay.setLayoutManager(new LinearLayoutManager(ApiCallUsingRetrofit.this));
                        weatherDataDisplay.setAdapter(new WeatherDataAdapter(weatherAPIModelClassArrayList));
                        DividerItemDecoration itemDecoration = new DividerItemDecoration(ApiCallUsingRetrofit.this, LinearLayoutManager.VERTICAL);
                        weatherDataDisplay.addItemDecoration(itemDecoration);
                    } else {
                        Toast.makeText(ApiCallUsingRetrofit.this, "List is Empty", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherAPIModel> call, Throwable t) {
                String message = "no network connection";
                Toast.makeText(ApiCallUsingRetrofit.this, message, Toast.LENGTH_SHORT).show();
            }
        });


    }

}

