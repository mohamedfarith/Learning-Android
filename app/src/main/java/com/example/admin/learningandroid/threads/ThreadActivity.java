package com.example.admin.learningandroid.threads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin.learningandroid.R;

public class ThreadActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnThreadExtendingThread;
    public Button btnThreadUsingRunnableInterface;
    public Button btnNetworkCallWithoutLibrary;
    public Button getBtnNetworkCallUsingLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_activity_layout);
        btnThreadExtendingThread = findViewById(R.id.btn_thread_extends_thread);
        btnThreadUsingRunnableInterface = findViewById(R.id.btn_thread_using_runnable_interface);
        btnNetworkCallWithoutLibrary = findViewById(R.id.btn_network_call);
        getBtnNetworkCallUsingLibrary = findViewById(R.id.btn_network_call_using_library);

        btnThreadExtendingThread.setOnClickListener(this);
        btnThreadUsingRunnableInterface.setOnClickListener(this);
        btnNetworkCallWithoutLibrary.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_thread_extends_thread:
                Intent extendingThreadIntent = new Intent(ThreadActivity.this,ThreadActivityExtendingThread.class);
                startActivity(extendingThreadIntent);
                break;
            case R.id.btn_thread_using_runnable_interface:
                Intent threadRunnableIntent = new Intent(ThreadActivity.this,ThreadActivityImplementingRunnable.class);
                startActivity(threadRunnableIntent);
                break;
            case R.id.btn_network_call:
                Intent networkCallIntent = new Intent(ThreadActivity.this,MakeAPICallActivity.class);
                startActivity(networkCallIntent);
        }
    }
}
