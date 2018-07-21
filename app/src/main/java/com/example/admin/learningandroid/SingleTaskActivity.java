package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SingleTaskActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "singleTask";
    Button singleTopButton2;
    Button singleTaskButton2;
    Button singleInstanceButton2;
    Button standardButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singletask_layout);
        singleTopButton2 = findViewById(R.id.singleTopButton2);
        singleTaskButton2 = findViewById(R.id.singleTaskButton2);
        singleInstanceButton2 = findViewById(R.id.singleInstanceButton2);
        standardButton2 = findViewById(R.id.standardButton2);
        singleTopButton2.setOnClickListener(this);


        singleTaskButton2.setOnClickListener(this);
        singleInstanceButton2.setOnClickListener(this);
        standardButton2.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.singleTopButton2:
                Intent intent = new Intent(SingleTaskActivity.this, SingleTopActivity.class);
                startActivity(intent);
                break;
            case R.id.singleTaskButton2:
                Intent intent1 = new Intent(SingleTaskActivity.this, SingleTaskActivity.class);
                startActivity(intent1);
                break;
            case R.id.singleInstanceButton2:
                Intent intent2 = new Intent(SingleTaskActivity.this, SingleInstanceActivity.class);
                startActivity(intent2);
                break;
            case R.id.standardButton2:
                Intent intent3 = new Intent(SingleTaskActivity.this, StandardTaskActivity.class);
                startActivity(intent3);
                break;


        }
    }
}
