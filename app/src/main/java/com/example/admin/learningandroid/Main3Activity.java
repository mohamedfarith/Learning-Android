package com.example.admin.learningandroid;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

private static String TAG = "Main3Activity";
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        Log.v(TAG,"OnCreate method of Activity1 is called");
        TextView textView = (TextView) findViewById(R.id.textView);
        Button btn = (Button) findViewById(R.id.btn);

         edit = (EditText) findViewById(R.id.edit);

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent  = new Intent( Main3Activity.this,Main4Activity.class);
                 intent.putExtra("Hello",edit.getText().toString());
                 startActivity(intent);
             }
         });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart method of Activity1 is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume method of Activity1 is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG," onPause method of Activity1 is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG,"onStop method of Activity1 is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG,"onRestart method of Activity1 is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy method of Activity1 is called");
    }
}
