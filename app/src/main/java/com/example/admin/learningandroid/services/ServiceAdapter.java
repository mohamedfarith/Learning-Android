package com.example.admin.learningandroid.services;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.learningandroid.R;
import com.example.admin.learningandroid.entity.WeatherAPIModelClass;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {
    private ArrayList<WeatherAPIModelClass> weatherList;

    ServiceAdapter(ArrayList<WeatherAPIModelClass> weatherDataList) {
        this.weatherList = weatherDataList;
    }

    @Override
    public ServiceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.service_weather_list_item, parent, false);
        return new ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ServiceViewHolder holder, int position) {
        WeatherAPIModelClass modelClass = weatherList.get(position);
        String message = "pressure: " + modelClass.getPressure();
        holder.pressureValue.setText(message);
        message = "Humidity: " + modelClass.getHumidity();
        holder.humidityValue.setText(message);
        message = "Main Data: " + modelClass.getMain();
        holder.weatherMain.setText(message);
        message = "Description: " + modelClass.getDescription();
        holder.weatherDescription.setText(message);
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        TextView pressureValue;
        TextView humidityValue;
        TextView weatherMain;
        TextView weatherDescription;

        public ServiceViewHolder(View itemView) {
            super(itemView);
            pressureValue = itemView.findViewById(R.id.txt_pressure_value);
            humidityValue = itemView.findViewById(R.id.txt_humidity_value);
            weatherMain = itemView.findViewById(R.id.txt_main_content);
            weatherDescription = itemView.findViewById(R.id.txt_description_content);

        }
    }
}
