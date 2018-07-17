package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SingleInstanceActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "SingleInstance";
    Button btnSingleTop;
    Button btnSingleTask;
    Button btnSingleInstance;
    Button btnStandardTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_instance_layout);
        btnSingleTop = findViewById(R.id.btnSingleTop);
        btnSingleTask = findViewById(R.id.btnSingleTask);
        btnSingleInstance = findViewById(R.id.btnSingleInstance);
        btnStandardTask = findViewById(R.id.btnStandardTask);


        btnSingleTop.setOnClickListener(this);
        btnSingleTask.setOnClickListener(this);
        btnSingleInstance.setOnClickListener(this);
        btnStandardTask.setOnClickListener(this);


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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSingleTop:
                Intent intent = new Intent(SingleInstanceActivity.this, SingleTopActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSingleTask:
                Intent intent1 = new Intent(SingleInstanceActivity.this, SingleTaskActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnSingleInstance:
                Intent intent2 = new Intent(SingleInstanceActivity.this, SingleInstanceActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnStandardTask:
                Intent intent3 = new Intent(SingleInstanceActivity.this, StandardTaskActivity.class);
                startActivity(intent3);
                break;


        }

    }
}
