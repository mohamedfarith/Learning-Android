package com.example.admin.learningandroid.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class WeatherAPIModel implements Parcelable {
    public static final Creator<WeatherAPIModel> CREATOR = new Creator<WeatherAPIModel>() {
        @Override
        public WeatherAPIModel createFromParcel(Parcel in) {
            return new WeatherAPIModel(in);
        }

        @Override
        public WeatherAPIModel[] newArray(int size) {
            return new WeatherAPIModel[size];
        }
    };
    List<WeatherAPIModel> list;
    String pressure;
    String humidity;
    List<WeatherAPIModel> weather;
    String main;
    String description;

    public WeatherAPIModel(String pressure, String humidity, String main, String description) {
        this.pressure = pressure;
        this.humidity = humidity;
        this.main = main;
        this.description = description;
    }

    protected WeatherAPIModel(Parcel in) {
        // list = in.createTypedArrayList(WeatherAPIModel.CREATOR);
        pressure = in.readString();
        humidity = in.readString();
        //  weather = in.createTypedArrayList(WeatherAPIModel.CREATOR);
        main = in.readString();
        description = in.readString();
    }

    public List<WeatherAPIModel> getList() {
        return list;
    }

    public List<WeatherAPIModel> getWeather() {
        return weather;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pressure);
        dest.writeString(humidity);
        dest.writeString(main);
        dest.writeString(description);
    }
}
