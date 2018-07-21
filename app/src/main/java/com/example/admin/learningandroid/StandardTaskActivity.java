package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StandardTaskActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "Standard_Task";
    Button singleTopButton;
    Button singleTaskButton;
    Button singleInstanceButton;
    Button standardTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standardtask_layout);

        singleTopButton = findViewById(R.id.singleTopButton);
        singleTaskButton = findViewById(R.id.singleTaskButton);
        singleInstanceButton = findViewById(R.id.singleInstanceButton);
        standardTaskButton = findViewById(R.id.standardTaskButton);
        singleTopButton.setOnClickListener(this);
        singleTaskButton.setOnClickListener(this);
        singleInstanceButton.setOnClickListener(this);
        standardTaskButton.setOnClickListener(this);


        Log.v(TAG, "OnCreate of Standard_Task");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "OnStart of Standard_Task");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "OnResume of Standard_Task");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "OnStop of Standard_Task");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "OnPause of Standard_Task");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "OnDestroy of Standard_Task");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "OnRestart of Standard_Task");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.standardTaskButton:
                Intent intent = new Intent(StandardTaskActivity.this, StandardTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.singleTopButton:
                Intent intent1 = new Intent(StandardTaskActivity.this, SingleTopActivity.class);
                startActivity(intent1);
                break;
            case R.id.singleTaskButton:
                Intent intent2 = new Intent(StandardTaskActivity.this, SingleTaskActivity.class);
                startActivity(intent2);
                break;
            case R.id.singleInstanceButton:
                Intent intent3 = new Intent(StandardTaskActivity.this, SingleInstanceActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
