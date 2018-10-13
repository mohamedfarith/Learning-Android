package com.example.admin.learningandroid.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherAPIModelClass implements Parcelable {
    private String mPressure;
    private String mHumidity;
    private String mMain;
    private String mDescription;

    public WeatherAPIModelClass(String mPressure, String mHumidity, String mMain, String mDescription) {
        this.mPressure = mPressure;
        this.mHumidity = mHumidity;
        this.mMain = mMain;
        this.mDescription = mDescription;
    }

    protected WeatherAPIModelClass(Parcel in) {
        mPressure = in.readString();
        mHumidity = in.readString();
        mMain = in.readString();
        mDescription = in.readString();
    }

    public static final Creator<WeatherAPIModelClass> CREATOR = new Creator<WeatherAPIModelClass>() {
        @Override
        public WeatherAPIModelClass createFromParcel(Parcel in) {
            return new WeatherAPIModelClass(in);
        }

        @Override
        public WeatherAPIModelClass[] newArray(int size) {
            return new WeatherAPIModelClass[size];
        }
    };

    public String getPressure() {
        return mPressure;
    }

    public void setPressure(String mPressure) {
        this.mPressure = mPressure;
    }

    public String getHumidity() {
        return mHumidity;
    }

    public void setHumidity(String mHumidity) {
        this.mHumidity = mHumidity;
    }

    public String getMain() {
        return mMain;
    }

    public void setMain(String mMain) {
        this.mMain = mMain;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mPressure);
        parcel.writeString(mHumidity);
        parcel.writeString(mMain);
        parcel.writeString(mDescription);
    }
}
