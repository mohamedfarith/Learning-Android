package com.example.admin.learningandroid.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.admin.learningandroid.R;
import com.example.admin.learningandroid.entity.WeatherAPIModelClass;

import java.util.ArrayList;

import okhttp3.internal.Util;

import static com.example.admin.learningandroid.Constants.NOTIFICATION;

/*
 * This activity involves using of background service to execute a network call
 * retrieving JSON data.
 * A service named WeatherService that extends IntentService is used to do the background
 * process and the result is posted to the UI through BroadCastReceiver.
 */
public class ServiceActivity extends AppCompatActivity {
    public Button btnStartService;
    ArrayList<WeatherAPIModelClass> weatherList;
    RecyclerView weatherDataRecyclerView;
    ProgressBar progressLoader;
    BroadcastReceiver weatherIntentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            progressLoader.setVisibility(View.GONE);
            weatherList = intent.getParcelableArrayListExtra("WEATHER_LIST");

            weatherDataRecyclerView.setLayoutManager(
                    new LinearLayoutManager(ServiceActivity.this));
            weatherDataRecyclerView.setAdapter(new ServiceAdapter(weatherList));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration
                    (ServiceActivity.this, LinearLayoutManager.VERTICAL);
            weatherDataRecyclerView.addItemDecoration(dividerItemDecoration);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_layout);
        btnStartService = findViewById(R.id.btn_start_service);
        weatherDataRecyclerView = findViewById(R.id.recycler_view_service);
        progressLoader = findViewById(R.id.progress_bar);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressLoader.setVisibility(View.VISIBLE);
                if (!checkNetworkConnection()) {
                    progressLoader.setVisibility(View.INVISIBLE);
                    Toast.makeText(ServiceActivity.this, "No network", Toast.LENGTH_SHORT).show();
                } else {
                    progressLoader.setVisibility(View.VISIBLE);
                    Intent serviceIntent = new Intent(ServiceActivity.this,
                            WeatherIntentService.class);

                    startService(serviceIntent);
                }
            }
        });
    }

    boolean checkNetworkConnection() {
        ConnectivityManager conn = (ConnectivityManager) getApplicationContext()
                .getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = conn.getActiveNetworkInfo();
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
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(weatherIntentReceiver);
    }
}
