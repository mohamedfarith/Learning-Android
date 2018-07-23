package com.example.admin.learningandroid.tasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.R;

public class LearningTasksActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnStandardTask;
    public Button btnSingleTop;
    public Button btnSingleTask;
    public Button btnSingleInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks_layout);

        btnStandardTask = findViewById(R.id.btn_standard_task);
        btnSingleTop = findViewById(R.id.btn_single_top);
        btnSingleTask = findViewById(R.id.btn_single_task);
        btnSingleInstance = findViewById(R.id.btn_single_instance);

        btnStandardTask.setOnClickListener(this);
        btnSingleTop.setOnClickListener(this);
        btnSingleTask.setOnClickListener(this);
        btnSingleInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_standard_task:
                Intent intentStandardTask = new Intent(LearningTasksActivity.this, StandardTaskActivity.class);
                startActivity(intentStandardTask);
                break;
            case R.id.btn_single_top:
                Intent intentSingleTop = new Intent(LearningTasksActivity.this, SingleTopActivity.class);
                startActivity(intentSingleTop);
                break;
            case R.id.btn_single_task:
                Intent intentSingleTask = new Intent(LearningTasksActivity.this, SingleTaskActivity.class);
                startActivity(intentSingleTask);
                break;
            case R.id.btn_single_instance:
                Intent intentSingleInstance = new Intent(LearningTasksActivity.this, SingleInstanceActivity.class);
                startActivity(intentSingleInstance);


        }
    }
}
