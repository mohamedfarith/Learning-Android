package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_of_Learning_Activity extends AppCompatActivity {
    Button activity_lifecycle, tasks, passing_object;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_of_activity_learning);
        activity_lifecycle = (Button) findViewById(R.id.activity_lifecycle);
        tasks = (Button) findViewById(R.id.tasks);
        passing_object = (Button) findViewById(R.id.passing_object);


        activity_lifecycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent l = new Intent(Activity_of_Learning_Activity.this, Activity_of_Learning_Activity_Lifecycle_1.class);
                startActivity(l);
            }
        });
        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Learning_Activity.this, Activity_of_Learning_Tasks.class);
                startActivity(intent);
            }
        });

        passing_object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Learning_Activity.this, Activity_of_Passing_Object.class);
                startActivity(intent);
            }
        });
    }
}
