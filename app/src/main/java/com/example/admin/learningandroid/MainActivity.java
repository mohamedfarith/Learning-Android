package com.example.admin.learningandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button activity_button, layout_button, fragment_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        activity_button = (Button) findViewById(R.id.activity_button);
        layout_button = (Button) findViewById(R.id.layout_button);
        fragment_button = (Button) findViewById(R.id.fragment_button);


        activity_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_of_Learning_Activity.class);
                startActivity(intent);
            }
        });
        layout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity_of_Layout_Activity.class);
                startActivity(intent);
            }
        });
    }
}
