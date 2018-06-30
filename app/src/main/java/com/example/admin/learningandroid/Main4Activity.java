package com.example.admin.learningandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    private static final String TAG = "Main4Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);
        Log.v(TAG,"onCreate method of Activity2 is called");
        TextView editedtext = (TextView) findViewById(R.id.editedtext);
        editedtext.setText(getIntent().getStringExtra("Hello"));
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart method of Activity2 is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume method of Activity2 is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG," onPause method of Activity2 is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop method of Activity2 is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"onRestart method of Activity2 is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy method of Activity2 is called");
    }
}


