package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_of_Single_Task extends AppCompatActivity {
    String Tag = "single_Task";
    Button single_top, single_task, single_instance, standard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_of_single_task);
        single_top = (Button) findViewById(R.id.single_top_button2);
        single_task = (Button) findViewById(R.id.single_task_button2);
        single_instance = (Button) findViewById(R.id.single_instance_button2);
        standard = (Button) findViewById(R.id.standard_button2);
        single_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Single_Task.this, Activity_of_Single_Top.class);
                startActivity(intent);
            }
        });
        single_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Single_Task.this, Activity_of_Single_Task.class);
                startActivity(intent);
            }
        });
        single_instance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Single_Task.this, Activity_of_Single_Instance.class);
                startActivity(intent);
            }
        });
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Single_Task.this, Activity_of_Standard_Task.class);
                startActivity(intent);

            }
        });
        Log.e(Tag, "OnCreate of Single_Task");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(Tag, "OnStart of single_Task");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(Tag, "OnResume of single_Task");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(Tag, "OnStop of single_Task");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e(Tag, "OnPause of single_Task");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(Tag, "OnDestroy of single_Task");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(Tag, "OnRestart of single_Task");
    }
}
