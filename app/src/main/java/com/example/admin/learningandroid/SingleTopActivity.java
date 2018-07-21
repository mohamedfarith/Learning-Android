package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.SingleLineTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SingleTopActivity extends AppCompatActivity implements View.OnClickListener {
    public static String TAG = "SingleTop";
    Button btnStandardTask;
    Button singleTopButton1;
    Button singleTaskButton1;
    Button singleInstanceButton1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_top_layout);
        Log.v(TAG, "OnCreate of SingleTop");
        singleTopButton1 = findViewById(R.id.singleTopButton1);
        singleTaskButton1 = findViewById(R.id.singleTaskButton1);
        singleInstanceButton1 = findViewById(R.id.singleInstanceButton1);
        btnStandardTask = findViewById(R.id.standardButton1);

        btnStandardTask.setOnClickListener(this);
        singleTopButton1.setOnClickListener(this);
        singleTaskButton1.setOnClickListener(this);
        singleInstanceButton1.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStandardTask:
                Intent intent = new Intent(SingleTopActivity.this, StandardTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.singleTopButton1:
                Intent intent1 = new Intent(SingleTopActivity.this, SingleTopActivity.class);
                startActivity(intent1);
                break;
            case R.id.singleTaskButton1:
                Intent intent2 = new Intent(SingleTopActivity.this, SingleTaskActivity.class);
                startActivity(intent2);
                break;
            case R.id.singleInstanceButton1:
                Intent intent3 = new Intent(SingleTopActivity.this, SingleInstanceActivity.class);
                startActivity(intent3);
                break;


        }
    }
}
