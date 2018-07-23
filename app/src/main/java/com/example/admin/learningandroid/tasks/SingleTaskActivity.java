package com.example.admin.learningandroid.tasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.R;

public class SingleTaskActivity extends AppCompatActivity {
    public static final String TAG = "singleTask";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singletask_layout);


        Log.v(TAG, "OnCreate of SingleTask");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "OnStart of singleTask");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "OnResume of singleTask");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "OnStop of singleTask");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "OnPause of singleTask");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy of singleTask");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "OnRestart of singleTask");
    }


}
