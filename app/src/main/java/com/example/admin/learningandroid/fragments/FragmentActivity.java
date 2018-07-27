package com.example.admin.learningandroid.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.admin.learningandroid.R;


public class FragmentActivity extends AppCompatActivity implements PassingData {
    private static final String TAG = "Fragment Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);
        Log.v(TAG, "onCreate of Fragment Activity");
    }

    @Override
    public void changeData(String textData, EditText etSendingFragment) {
        FragmentManager manager = getSupportFragmentManager();
        ReceivingFragment receivingFragment = (ReceivingFragment) manager.findFragmentById(R.id.receiving_fragment);
        receivingFragment.getData(textData, etSendingFragment);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart of Fragment Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume of Fragment Activity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause of Fragment Activity");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop of Fragment Activity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "onRestart of Fragment Activity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy of Fragment Activity");
    }
}
