package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SingleTaskActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "singleTask";
    Button btnSingleTop;
    Button btnSingleTask;
    Button btnSingleInstance;
    Button btnStandardTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singletask_layout);
        btnSingleTop = findViewById(R.id.singleTopButton2);
        btnSingleTask = findViewById(R.id.singleTaskButton2);
        btnSingleInstance = findViewById(R.id.singleInstanceButton2);
        btnStandardTask = findViewById(R.id.standardButton2);
        btnSingleTop.setOnClickListener(this);


        btnSingleTask.setOnClickListener(this);
        btnSingleInstance.setOnClickListener(this);
        btnStandardTask.setOnClickListener(this);
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
            case R.id.btnSingleTop:
                Intent intent = new Intent(SingleTaskActivity.this, SingleTopActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSingleTask:
                Intent intent1 = new Intent(SingleTaskActivity.this, SingleTaskActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnSingleInstance:
                Intent intent2 = new Intent(SingleTaskActivity.this, SingleInstanceActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnStandardTask:
                Intent intent3 = new Intent(SingleTaskActivity.this, StandardTaskActivity.class);
                startActivity(intent3);
                break;


        }
    }
}
