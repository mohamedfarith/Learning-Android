package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Activity_of_Learning_Activity_Lifecycle_1 extends AppCompatActivity {
    String Tag = "activity_1";
    Button next_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_of__learning__activity__lifecycle_1);
        Log.e(Tag, "OnCreate of activity1");
        next_activity = (Button) findViewById(R.id.next_activity);
        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_of_Learning_Activity_Lifecycle_1.this, Activity_of_Learning_Activity_Lifecycle_2.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(Tag, "OnStart of activity1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(Tag, "OnResume of activity1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(Tag, "OnStop of activity1");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e(Tag, "OnPause of activity1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(Tag, "OnDestroy of activity1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(Tag, "OnRestart of activity1");
    }
}

