package com.example.admin.learningandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityLifecycleTwo extends AppCompatActivity {
    public static final String TAG = "Activity 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_layout2);
        Log.v(TAG, "OnCreate of activity 2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "OnStart of activity 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "OnResume of activity 2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "OnStop of activity 2");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "OnPause of activity 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy of activity1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "OnRestart of activity 2");
    }
}
