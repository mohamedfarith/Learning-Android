package com.example.admin.learningandroid.threads;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.learningandroid.R;

import static com.example.admin.learningandroid.Constants.THREAD;

public class ThreadActivityExtendingThread extends AppCompatActivity implements View.OnClickListener {

    public Button btnStartThread;
    public TextView txtStartThread;
    public Handler threadActivityHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_extending_thread);
        btnStartThread = findViewById(R.id.btn_start_thread);
        txtStartThread = findViewById(R.id.txt_start_thread);
        btnStartThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_thread:
                ExampleThread thread = new ExampleThread();
                thread.start();
                break;

        }
    }

    class ExampleThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d(THREAD, "onClick " + i);
                if (i == 5) {
                    //Updating the UI by using Handler
                    threadActivityHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            txtStartThread.setText("thread completed");
                        }
                    });
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }


    }
}

