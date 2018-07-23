package com.example.admin.learningandroid.tasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.R;

public class SingleInstanceActivity extends AppCompatActivity {
    public static final String TAG = "SingleInstance";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_instance_layout);


        Log.v(TAG, "OnCreate of Single_Instance");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "OnStart of Single_Instance");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "OnResume of Single_Instance");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "OnStop of Single_Instance");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "OnPause of Single_Instance");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy of Single_Instance");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "OnRestart of Single_Instance");
    }


}
