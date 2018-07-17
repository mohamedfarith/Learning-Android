package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearningTasksActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStandardTask;
    Button btnSingleTop;
    Button btnSingleTask;
    Button btnSingleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_layout);

        btnStandardTask = findViewById(R.id.btnStandardTask);
        btnSingleTop = findViewById(R.id.btnSingleTop);
        btnSingleTask = findViewById(R.id.btnSingleTask);
        btnSingleInstance = findViewById(R.id.btnSingleInstance);

        btnStandardTask.setOnClickListener(this);
        btnSingleTop.setOnClickListener(this);
        btnSingleTask.setOnClickListener(this);
        btnSingleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStandardTask:
                Intent i = new Intent(LearningTasksActivity.this, StandardTaskActivity.class);
                startActivity(i);
                break;
            case R.id.btnSingleTop:
                Intent in = new Intent(LearningTasksActivity.this, SingleTopActivity.class);
                startActivity(in);
                break;
            case R.id.btnSingleTask:
                Intent l = new Intent(LearningTasksActivity.this, SingleTaskActivity.class);
                startActivity(l);
                break;
            case R.id.btnSingleInstance:
                Intent intent = new Intent(LearningTasksActivity.this, SingleInstanceActivity.class);
                startActivity(intent);


        }
    }
}
