package com.example.admin.learningandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.R;

public class ActivityLifecycleOne extends AppCompatActivity {
    public static final String TAG = "activity_1";
    public Button btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lifecycle_one_layout);
        Log.v(TAG, "OnCreate of activity1");
        btnNextActivity = findViewById(R.id.next_activity);
        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLifecycle = new Intent(ActivityLifecycleOne.this, ActivityLifecycleTwo.class);
                startActivity(intentLifecycle);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "OnStart of activity1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "OnResume of activity1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "OnStop of activity1");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "OnPause of activity1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy of activity1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "OnRestart of activity1");
    }
}

