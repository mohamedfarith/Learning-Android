package com.example.admin.learningandroid.threads;

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
import com.example.admin.learningandroid.entity.ListDataRetrieveModelClass;
import com.example.admin.learningandroid.entity.RetrofitWeatherApiModelClass;
import com.example.admin.learningandroid.entity.Weather;
import com.example.admin.learningandroid.entity.WeatherAPIModelClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.admin.learningandroid.Constants.BASE_WEATHER_URL;

public class ApiCallUsingRetrofit extends AppCompatActivity {
    ArrayList<WeatherAPIModelClass> weatherAPIModelClassArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_weather_api_layout);
        final RecyclerView weatherDataDisplay = findViewById(R.id.retrofit_weather_api_recycler_view);

        Retrofit dataRetreive = new Retrofit.Builder()
                .baseUrl(ApiCall.weatherURL)
                .addConverterFactory(GsonConverterFactory
                        .create()).build();
        ApiCall apiCall = dataRetreive.create(ApiCall.class);
        Call<ListDataRetrieveModelClass> listDataRetrieveModelClassCall = apiCall.getWeatherData();
        listDataRetrieveModelClassCall.enqueue(new Callback<ListDataRetrieveModelClass>() {
            @Override
            public void onResponse(Call<ListDataRetrieveModelClass> call, Response<ListDataRetrieveModelClass> response) {

                ListDataRetrieveModelClass listDataRetrieveModelClass = response.body();
                //Getting the list Array by creating an object of ListDataRetreiveModelClass


                ;
                for (int i = 0; i < listDataRetrieveModelClass.getList().size(); i++) {


                    //Getting the objects available inside list array

                    RetrofitWeatherApiModelClass retrofitWeatherApiModelClass = listDataRetrieveModelClass.getList().get(i);
                    String pressure = retrofitWeatherApiModelClass.getPressure();
                    String humidity = retrofitWeatherApiModelClass.getHumidity();


                    //Getting the key - value pairs available inside weather list at index 0
                    List<Weather> weatherJSONDataList = retrofitWeatherApiModelClass.getWeatherListData();
                    Weather weatherData = weatherJSONDataList.get(0);
                    String main = weatherData.getMain();
                    String description = weatherData.getDescription();


                    weatherAPIModelClassArrayList.add(new WeatherAPIModelClass(pressure, humidity, main, description));
                }
                weatherDataDisplay.setLayoutManager(new LinearLayoutManager(ApiCallUsingRetrofit.this));
                weatherDataDisplay.setAdapter(new RetrofitWeatherAdapter(weatherAPIModelClassArrayList));
                DividerItemDecoration itemDecoration = new DividerItemDecoration(ApiCallUsingRetrofit.this, LinearLayoutManager.VERTICAL);
                weatherDataDisplay.addItemDecoration(itemDecoration);
            }

            @Override
            public void onFailure(Call<ListDataRetrieveModelClass> call, Throwable t) {
                String message = "no network connection";
                Toast.makeText(ApiCallUsingRetrofit.this, message, Toast.LENGTH_SHORT).show();
            }
        });


    }

}

class RetrofitWeatherAdapter extends RecyclerView.Adapter<RetrofitWeatherAdapter.WeatherListViewHolder> {
    List<WeatherAPIModelClass> weatherList;

    RetrofitWeatherAdapter(List<WeatherAPIModelClass> weatherList) {
        this.weatherList = weatherList;
    }

    @Override
    public WeatherListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View weatherView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_list_item, parent, false);
        return new WeatherListViewHolder(weatherView);
    }

    @Override
    public void onBindViewHolder(WeatherListViewHolder holder, int position) {

        WeatherAPIModelClass modelClass = weatherList.get(position);
        String message = "pressure: " + modelClass.getPressure();
        holder.pressureLevel.setText(message);
        message = "Humidity: " + modelClass.getHumidity();
        holder.humidityLevel.setText(message);
        message = "Main Data: " + modelClass.getMain();
        holder.weatherMain.setText(message);
        message = "Description: " + modelClass.getDescription();
        holder.weatherDescription.setText(message);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    class WeatherListViewHolder extends RecyclerView.ViewHolder {
        TextView pressureLevel;
        TextView humidityLevel;
        TextView weatherMain;
        TextView weatherDescription;

        public WeatherListViewHolder(View itemView) {
            super(itemView);
            pressureLevel = itemView.findViewById(R.id.txt_pressure_level);
            humidityLevel = itemView.findViewById(R.id.txt_humidity_level);
            weatherMain = itemView.findViewById(R.id.txt_weather_main);
            weatherDescription = itemView.findViewById(R.id.txt_weather_description);

        }
    }
}
