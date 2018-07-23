package com.example.admin.learningandroid.tasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.R;

public class SingleTopActivity extends AppCompatActivity {
    public static String TAG = "SingleTop";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_top_layout);
        Log.v(TAG, "OnCreate of SingleTop");

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "OnStart ofSingleTop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "OnResume of SingleTop");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "OnStop of SingleTop");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "OnPause of SingleTop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy of SingleTop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "OnRestart of SingleTop");
    }

}
