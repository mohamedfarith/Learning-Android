package com.example.admin.learningandroid.entity;

public class Weather {
     String main;
    String description;

    public Weather(String mMain, String mDescription) {
        this.main = mMain;
        this.description = mDescription;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String mMain) {
        this.main = mMain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String mDescription) {
        this.description = mDescription;
    }
}
