package com.example.admin.learningandroid.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.learningandroid.R;


public class FragmentActivity extends AppCompatActivity implements DataTransferBetweenFragments {
    private static final String TAG = "Fragment Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);
        Log.v(TAG, "onCreate of Fragment Activity");
    }

    @Override
    public void setData(String textData) {
        FragmentManager manager = getSupportFragmentManager();
        ReceivingFragment receivingFragment = (ReceivingFragment) manager.findFragmentById(R.id.receiving_fragment);
        receivingFragment.getData(textData);
    }

    @Override
    public void clearData() {
        FragmentManager fManager = getSupportFragmentManager();
        SendingFragment sendingFragment = (SendingFragment) fManager.findFragmentById(R.id.sending_fragment);
        sendingFragment.clearingEditTextOnButtonClick();
    }
}
