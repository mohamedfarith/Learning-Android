package com.example.admin.learningandroid.services;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.admin.learningandroid.R;
import com.example.admin.learningandroid.entity.WeatherAPIModel;
import com.example.admin.learningandroid.entity.WeatherDataAdapter;
import com.example.admin.learningandroid.threads.ApiCall;

import java.util.ArrayList;

import static com.example.admin.learningandroid.Constants.NOTIFICATION;
import static com.example.admin.learningandroid.Constants.WEATHER_LIST;

/*
 * This activity involves using of background service to execute a network call
 * retrieving JSON data.
 * A service named WeatherIntentService that extends IntentService is used to do the background
 * process and the result is posted to the UI through BroadCastReceiver.
 * A service named ApiCallService is implemented to do the background process by extending Service class
 * and boundService is implemented to communicate with activity.
 */
public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnStartIntentService;
    public Button btnStartService;
    public Button btnBindService;
    public Button btnBoundDataView;
    ApiCallService apiCallService;
    ArrayList<WeatherAPIModel> weatherList;
    RecyclerView weatherDataRecyclerView;
    ProgressBar progressLoader;
    Boolean isBound = false;
    Intent bindServiceIntent;
    Intent serviceIntent;
    //BroadCastReceiver to receive the broadcast sent from the activity.
    BroadcastReceiver weatherIntentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            progressLoader.setVisibility(View.GONE);
            weatherList = intent.getParcelableArrayListExtra(WEATHER_LIST);
            weatherDataRecyclerView.setLayoutManager(new LinearLayoutManager(ServiceActivity.this));
            weatherDataRecyclerView.setAdapter(new WeatherDataAdapter(weatherList));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(ServiceActivity.this, LinearLayoutManager.VERTICAL);
            weatherDataRecyclerView.addItemDecoration(dividerItemDecoration);
        }
    };
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ApiCallService.ServiceBinder serviceBinder = (ApiCallService.ServiceBinder) service;
            apiCallService = serviceBinder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
            Toast.makeText(ServiceActivity.this, "Service Disconnected", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
        btnBoundDataView = findViewById(R.id.btn_bound_data_view);
        //Data from Binding to the service is displayed on button click.Click this after clicking BindService button
        btnBoundDataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressLoader.setVisibility(View.GONE);
                ArrayList<WeatherAPIModel> weatherDataList = apiCallService.getWeatherList();
                weatherDataRecyclerView.setLayoutManager(new LinearLayoutManager(ServiceActivity.this));
                weatherDataRecyclerView.setAdapter(new WeatherDataAdapter(weatherDataList));
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(ServiceActivity.this, LinearLayoutManager.VERTICAL);
                weatherDataRecyclerView.addItemDecoration(dividerItemDecoration);
                unbindService(serviceConnection);
            }
        });
        btnStartIntentService = findViewById(R.id.btn_start_intent_service);
        btnStartService = findViewById(R.id.btn_start_service);
        btnBindService = findViewById(R.id.btn_bind_service);
        btnStartService.setOnClickListener(this);
        btnStartIntentService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
        weatherDataRecyclerView = findViewById(R.id.recycler_view_service);
        progressLoader = findViewById(R.id.progress_bar);

    }

    //Check for the network connectivity
    boolean checkNetworkConnection() {
        ConnectivityManager networkConnection = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = networkConnection.getActiveNetworkInfo();
        if (info == null) {
            return false;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(weatherIntentReceiver, new IntentFilter(NOTIFICATION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isBound) {
            unbindService(serviceConnection);
            isBound = false;
        }
        unregisterReceiver(weatherIntentReceiver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_intent_service:
                progressLoader.setVisibility(View.VISIBLE);
                if (!checkNetworkConnection()) {
                    progressLoader.setVisibility(View.INVISIBLE);
                    Toast.makeText(ServiceActivity.this, "No network", Toast.LENGTH_SHORT).show();
                } else {
                    progressLoader.setVisibility(View.VISIBLE);
                    Intent serviceOnHandleIntent = new Intent(ServiceActivity.this, WeatherIntentService.class);
                    startService(serviceOnHandleIntent);
                }
                break;
            case R.id.btn_start_service:
                progressLoader.setVisibility(View.VISIBLE);
                serviceIntent = new Intent(ServiceActivity.this, ApiCallService.class);
                startService(serviceIntent);

                break;
            case R.id.btn_bind_service:
                progressLoader.setVisibility(View.VISIBLE);
                bindServiceIntent = new Intent(ServiceActivity.this, ApiCallService.class);
                bindService(bindServiceIntent, serviceConnection, BIND_AUTO_CREATE);
                break;
        }
    }

}
