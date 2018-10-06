package com.example.admin.learningandroid.entity;

import java.util.List;

public class ListDataRetrieveModelClass {
    List<RetrofitWeatherApiModelClass> list;

    public ListDataRetrieveModelClass(List<RetrofitWeatherApiModelClass> list) {
        this.list = list;
    }

    public List<RetrofitWeatherApiModelClass> getList() {
        return list;
    }

    public void setList(List<RetrofitWeatherApiModelClass> list) {
        this.list = list;
    }
}
