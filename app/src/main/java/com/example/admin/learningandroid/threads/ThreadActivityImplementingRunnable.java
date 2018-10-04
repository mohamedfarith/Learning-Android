package com.example.admin.learningandroid.threads;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.learningandroid.R;

import static com.example.admin.learningandroid.Constants.THREAD;

public class ThreadActivityImplementingRunnable extends AppCompatActivity implements View.OnClickListener {
   public Button btnStartRunnableThread;
   public TextView txtStartRunnableThread;
   Handler threadActivityHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_using_runnable);
        btnStartRunnableThread = findViewById(R.id.btn_start_runnable_thread);
        txtStartRunnableThread = findViewById(R.id.txt_start_runnable_thread);
        btnStartRunnableThread.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        ExampleRunnableThread thread = new ExampleRunnableThread();
        new Thread(thread).start();
    }

    class ExampleRunnableThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                Log.d(THREAD, "onClick " + i);
                if (i == 5) {
                    //Updating the UI by using Handler
                    threadActivityHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            txtStartRunnableThread.setText("thread completed");
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
