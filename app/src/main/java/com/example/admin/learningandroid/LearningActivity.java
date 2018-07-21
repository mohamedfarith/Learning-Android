package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LearningActivity extends AppCompatActivity implements View.OnClickListener {
    public Intent intent;
    Button buttonActivityLifecycle;
    Button buttonTasks;
    Button buttonPassingObject;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learning_activity_layout);
        buttonActivityLifecycle = findViewById(R.id.buttonActivityLifecycle);
        buttonTasks = findViewById(R.id.buttonTasks);
        buttonPassingObject = findViewById(R.id.buttonPassingObject);
        buttonActivityLifecycle.setOnClickListener(this);
        buttonTasks.setOnClickListener(this);
        buttonPassingObject.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonActivityLifecycle:
                Intent l = new Intent(LearningActivity.this, ActivityLifecycleOne.class);
                startActivity(l);
                break;
            case R.id.buttonTasks:
                Intent intent = new Intent(LearningActivity.this, LearningTasksActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonPassingObject:
                Intent in = new Intent(LearningActivity.this, PassingObjectActivity.class);
                startActivity(in);
                break;

        }


    }
}
