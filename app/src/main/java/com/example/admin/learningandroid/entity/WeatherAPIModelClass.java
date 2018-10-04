package com.example.admin.learningandroid.entity;

public class WeatherAPIModelClass {
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


}
