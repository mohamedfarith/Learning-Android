package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_of_Learning_Tasks extends AppCompatActivity {
    Button standard_task, single_top, single_task, single_instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_of__learning__tasks);

        standard_task = (Button) findViewById(R.id.standard_task);
        single_top = (Button) findViewById(R.id.single_top);
        single_task = (Button) findViewById(R.id.single_task);
        single_instance = (Button) findViewById(R.id.single_instance);

        standard_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Learning_Tasks.this, Activity_of_Standard_Task.class);
                startActivity(intent);
            }
        });
        single_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Learning_Tasks.this, Activity_of_Single_Top.class);
                startActivity(intent);
            }
        });
        single_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Learning_Tasks.this, Activity_of_Single_Task.class);
                startActivity(intent);
            }

        });
        single_instance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Learning_Tasks.this, Activity_of_Single_Instance.class);
                startActivity(intent);
            }
        });
    }
}
