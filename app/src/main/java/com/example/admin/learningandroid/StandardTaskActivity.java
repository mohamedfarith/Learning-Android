package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StandardTaskActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "Standard_Task";
    Button btnSingleTop;
    Button btnSingleTask;
    Button btnSingleInstance;
    Button btnStandardTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.standardtask_layout);

        btnSingleTop = findViewById(R.id.singleTopButton);
        btnSingleTask = findViewById(R.id.singleTaskButton);
        btnSingleInstance = findViewById(R.id.singleInstanceButton);
        btnStandardTask = findViewById(R.id.standardTaskButton);
        btnSingleTop.setOnClickListener(this);
        btnSingleTask.setOnClickListener(this);
        btnSingleInstance.setOnClickListener(this);
        btnStandardTask.setOnClickListener(this);


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
            case R.id.btnStandardTask:
                Intent intent = new Intent(StandardTaskActivity.this, StandardTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSingleTop:
                Intent intent1 = new Intent(StandardTaskActivity.this, SingleTopActivity.class);
                startActivity(intent1);
                break;
            case R.id.btnSingleTask:
                Intent intent2 = new Intent(StandardTaskActivity.this, SingleTaskActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnSingleInstance:
                Intent intent3 = new Intent(StandardTaskActivity.this, SingleInstanceActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
