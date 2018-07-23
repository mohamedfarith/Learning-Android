package com.example.admin.learningandroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.tasks.LearningTasksActivity;
import com.example.admin.learningandroid.R;

public class LearningActivity extends AppCompatActivity implements View.OnClickListener {
    public Intent intent;
    public Button buttonActivityLifecycle;
    public Button buttonTasks;
    public Button buttonPassingObject;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_activity_layout);
        buttonActivityLifecycle = findViewById(R.id.button_activity_lifecycle);
        buttonTasks = findViewById(R.id.button_tasks);
        buttonPassingObject = findViewById(R.id.button_passing_object);

        buttonActivityLifecycle.setOnClickListener(this);
        buttonTasks.setOnClickListener(this);
        buttonPassingObject.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_activity_lifecycle:
                Intent intentActivity = new Intent(LearningActivity.this, ActivityLifecycleOne.class);
                startActivity(intentActivity);
                break;
            case R.id.button_tasks:
                Intent intentTasks = new Intent(LearningActivity.this, LearningTasksActivity.class);
                startActivity(intentTasks);
                break;
            case R.id.button_passing_object:
                Intent intentObject = new Intent(LearningActivity.this, PassingObjectActivity.class);
                startActivity(intentObject);
                break;

        }


    }
}
