package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Activity_of_Learning_Activity_Lifecycle_2 extends AppCompatActivity {
    String Tag = "Activity_2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_of__learning__activity__lifecycle_2);
        Log.e(Tag, "OnCreate of activity 2");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(Tag, "OnStart of activity 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(Tag, "OnResume of activity 2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(Tag, "OnStop of activity 2");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e(Tag, "OnPause of activity 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(Tag, "OnDestroy of activity1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(Tag, "OnRestart of activity 2");
    }
}
