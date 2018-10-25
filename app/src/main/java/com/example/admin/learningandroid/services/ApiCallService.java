package com.example.admin.learningandroid.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.example.admin.learningandroid.entity.WeatherAPIModel;
import com.example.admin.learningandroid.threads.MakeAPICallActivity;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.admin.learningandroid.Constants.NOTIFICATION;
import static com.example.admin.learningandroid.Constants.WEATHER_LIST;

public class ApiCallService extends Service {
    private static final String TAG = "ApiCallService";
    ArrayList<WeatherAPIModel> weatherList;
    IBinder iBinder = new ServiceBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    String jsonResponse = MakeAPICallActivity.getResponse();
                    weatherList = MakeAPICallActivity.getJSONObjects(jsonResponse);
                    Intent intentService = new Intent(NOTIFICATION);
                    intentService.putParcelableArrayListExtra(WEATHER_LIST, weatherList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    String jsonResponse = MakeAPICallActivity.getResponse();
                    weatherList = MakeAPICallActivity.getJSONObjects(jsonResponse);
                    Intent intentService = new Intent(NOTIFICATION);
                    intentService.putParcelableArrayListExtra(WEATHER_LIST, weatherList);
                    sendBroadcast(intentService);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public ArrayList<WeatherAPIModel> getWeatherList() {
        return weatherList;
    }

    public class ServiceBinder extends Binder {
        private static final String TAG = "ServiceBinder";

        ApiCallService getService() {
            Log.e(TAG, "getService: ");
            return ApiCallService.this;
        }
    }

}
