package com.example.admin.learningandroid.entity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.learningandroid.R;

import java.util.List;

public class WeatherDataAdapter extends RecyclerView.Adapter<WeatherDataAdapter.WeatherListViewHolder> {
    List<WeatherAPIModel> mWeatherList;
    Context mContext;
    String mMessage;

    public WeatherDataAdapter(List<WeatherAPIModel> weatherList) {
        this.mWeatherList = weatherList;
    }

    @Override
    public WeatherDataAdapter.WeatherListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View weatherView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_list_item, parent, false);
        return new WeatherDataAdapter.WeatherListViewHolder(weatherView);
    }

    @Override
    public void onBindViewHolder(WeatherDataAdapter.WeatherListViewHolder holder, int position) {
        WeatherAPIModel modelClass = mWeatherList.get(position);
        mMessage = "pressure: " + modelClass.getPressure();
        holder.pressureLevel.setText(mMessage);
        mMessage = "Humidity: " + modelClass.getHumidity();
        holder.humidityLevel.setText(mMessage);
        mMessage = "Main Data: " + modelClass.getMain();
        holder.weatherMain.setText(mMessage);
        mMessage = "Description: " + modelClass.getDescription();
        holder.weatherDescription.setText(mMessage);
    }

    @Override
    public int getItemCount() {
        return mWeatherList.size();
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
